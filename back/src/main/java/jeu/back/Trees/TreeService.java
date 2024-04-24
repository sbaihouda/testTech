package jeu.back.Trees;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TreeService {
    private final RestClient restClient;

    public TreeService(RestClient.Builder builder){
        this.restClient = builder
                .baseUrl("https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/les-arbres/records?limit=100")
                .build();
    }

    /**
     * Retrieves all tree data.
     *
     * @return Tree all tree data.
     */
    public Trees findAll(){
        return restClient.get()
                .uri("")
                .retrieve()
                .body(new ParameterizedTypeReference<Trees>() {
                });
    }

    /**
     * Retrieves and sorts all tree data by arrondissements.
     *
     * @return List of TreeData objects sorted by arrondissements.
     */
    public List<TreeData> findAllSortedByArrondissement() {
        // gathering data
        List<TreeData> allTreeData = findAll().results();

        // sorting data by arrondissements
        return allTreeData.stream()
                .sorted(Comparator.comparing(TreeData::getArrondissement))
                .toList();
    }

    /**
     * Retrieves and sorts all arrondissements.
     *
     * @return List of sorted arrondissements.
     */
    public List<String> findAllArrondissementsSorted() {
        // gathering data
        List<TreeData> allTreeData = findAllSortedByArrondissement();

        // extracting only sorted arrondissements
        return allTreeData.stream()
                .map(TreeData::getArrondissement)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Retrieves and sorts all tree types.
     *
     * @return List of sorted tree types.
     */
    public List<String> findAllTreeTypeSorted() {
        List<TreeData> allTreeData = findAllSortedByArrondissement();

        // sorting data and extracting tree type
        return allTreeData.stream()
                .map(TreeData::getGenre)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the count of each tree type.
     *
     * @return Map containing the count of each tree type.
     */
    public Map<String, Integer> getAllTreeWithReps(){
        List<String> treeTypes = findAllTreeTypeSorted();
        Map<String, Integer> repetitionsMap = new HashMap<>();
        for (String treeType : treeTypes) {
            // incrementing depending on current tree type
            repetitionsMap.put(treeType, repetitionsMap.getOrDefault(treeType, 0) + 1);
        }
        return repetitionsMap;
    }

    /**
     * Retrieves the count of trees in each arrondissement.
     *
     * @return Map containing the count of trees in each arrondissement.
     */
    public Map<String, Integer> getAllArrWithReps(){
        List<String> Arrondissements = findAllArrondissementsSorted();
        Map<String, Integer> repetitionsMap = new HashMap<>();
        for (String Arrondissement : Arrondissements) {
            // incrementing depending on current tree type
            repetitionsMap.put(Arrondissement, repetitionsMap.getOrDefault(Arrondissement, 0) + 1);
        }
        return repetitionsMap;
    }
}