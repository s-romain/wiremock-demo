package fr.sromain.wiremock.demo.enums;

import lombok.Getter;

@Getter
public enum Location {
    NANTES("Nantes", "FR", "Pays de la Loire", 47.2186371, -1.5541362, "nantes", """
            Nantes, sur les bords de la Loire, est une cité resplendissante, aux rues pavées menant à des merveilles
            architecturales témoins de son riche passé. Cette ville vibrante, où l'histoire, la culture, la modernité
            et le divertissement s'entrelacent, est un joyau rare, digne d'être exploré et apprécié. Sous les rayons 
            du soleil, les rues pavées étincellent, invitant les voyageurs à découvrir ses trésors cachés.
            """,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Panorama_depuis_Butte_Sainte-Anne.jpg/1920px-Panorama_depuis_Butte_Sainte-Anne.jpg"),
    LONDON("Londres", "GB", "England", 51.5073219, -0.1276474, null, """
            Londres, la cité cosmopolite, abrite des rues animées, des monuments emblématiques
            et une effervescence culturelle. Cette métropole, riche en histoire, regorge de surprises à chaque coin de
            rue, de la tour de Big Ben à la Tamise scintillante. Londres est un joyau qui mérite d'être exploré, un
            endroit où le passé et le présent se mêlent pour créer un avenir brillant.
            """,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Palace_of_Westminster_from_the_dome_on_Methodist_Central_Hall.jpg/1280px-Palace_of_Westminster_from_the_dome_on_Methodist_Central_Hall.jpg"),


    LYON("Lyon", "FR", "Auvergne-Rhône-Alpes", 45.7578137, 4.8320114, "lyon", """
            Lyon, la cité lumineuse, est une métropole aux rues pavées et aux bâtiments anciens qui témoignent de
            son riche patrimoine. Cette ville animée, où l'histoire, la gastronomie et la culture se côtoient, est un
            lieu de souvenirs intenses et de découvertes culinaires inoubliables. Les odeurs et les saveurs de Lyon,
            des quenelles à la soie, ravivent les souvenirs les plus enfouis, invitant les visiteurs à se perdre dans
            les méandres de la mémoire.
            """,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/From_Croix_Rousse_To_Fourvi%C3%A8re_%28161423721%29.jpeg/1920px-From_Croix_Rousse_To_Fourvi%C3%A8re_%28161423721%29.jpeg");


    final String city;
    final String country;
    final String state;
    final Double lat;
    final Double lon;
    final String jcDecauxContractName;
    final String description;
    final String urlImg;

    Location(
            String city,
            String country,
            String state,
            Double lat,
            Double lon,
            String jcDecauxContractName,
            String description,
            String urlImg
    ) {

        this.city = city;
        this.country = country;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
        this.jcDecauxContractName = jcDecauxContractName;
        this.description = description;
        this.urlImg = urlImg;
    }

    public static Location findByName(String name) {
        for (Location location : values()) {
            if (location.name().equals(name)) {
                return location;
            }
        }
        return null;
    }
}
