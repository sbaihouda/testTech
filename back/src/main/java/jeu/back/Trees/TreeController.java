package jeu.back.Trees;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TreeController {
    TreeService t;
    private final TreeService treeService;

    public TreeController(TreeService t1) {
        this.treeService = t1;
    }

    // Endpoint to retrieve all data
    @GetMapping("/test")
    public Trees test(){
        return treeService.findAll();
    }

    // Endpoint to retrieve all trees
    @GetMapping("/all")
    public List<TreeData> getAllTrees(){
        return treeService.findAll().results();
    }

    // endpoint to retrieve trees sorted by arrondissement
    @GetMapping("/sorteddatabyarrondissement")
    public Map<String, Integer> getDatasSortedByArrondissement(){
        return treeService.getAllArrWithReps();
    }

    // endpoint to retrieve count of trees by genre
    @GetMapping("/AllTreesGenreWithReps")
    public Map<String, Integer> getAllTreesGenre(){
        return treeService.getAllTreeWithReps();
    }

}