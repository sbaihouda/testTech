package jeu.back.Trees;


/*
*  [
    {
      "idbase": 280842,
      "typeemplacement": "Arbre",
      "domanialite": "Alignement",
      "arrondissement": "PARIS 8E ARRDT",
      "complementadresse": "33",
      "numero": null,
      "adresse": "AVENUE HOCHE",
      "idemplacement": "000501004",
      "libellefrancais": "Marronnier",
      "genre": "Aesculus",
      "espece": "hippocastanum",
      "varieteoucultivar": "''Baumannii''",
      "circonferenceencm": 22,
      "hauteurenm": 5,
      "stadedeveloppement": "Jeune (arbre)",
      "remarquable": "NON",
      "geo_point_2d": {
        "lon": 2.30068725859518,
        "lat": 48.876048471833
      }
    }
  ]
  * */
public record TreeData(
        int idbase,
        String typeemplacement,
        String domanialite,
        String arrondissement,
        String complementadresse,
        int numero,
        String adresse,
        String idemplacement,
        String libellefrancais,
        String genre,
        String espece,
        String varieteoucultivar,
        int circonferenceencm,
        int hauteurenm,
        String stadedeveloppement,
        String remarquable,
        GeoPoint2D geo_point_2d
) {
    public String getArrondissement() {
        return this.arrondissement;
    }

    public String getGenre() {
        return this.genre;
    }
}
