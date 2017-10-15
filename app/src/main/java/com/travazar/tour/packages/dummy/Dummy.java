package com.travazar.tour.packages.dummy;

import com.travazar.tour.packages.data.model.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kali_root on 10/13/2017.
 */

public class Dummy {
    public static List<String> getFeatures() {
        List<String> features = new ArrayList<>();
        features.add("http://aws-cdn-01.shemazing.ie/wp-content/uploads/2015/09/tower_2.jpg");
        features.add("https://www.vigattintourism.com/assets/tourist_spots_photos/optimize/13434614573sUQ7Z2J.jpg");
        features.add("https://philippinescities.com/wp-content/uploads/2013/05/tarshier-bohol.jpg");
        return features;
    }

    public static List<Attraction> getTopAttractions() {
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction",
                "https://2.bp.blogspot.com/-VmT8cnTLFSM/WKjVOIMymPI/AAAAAAAAEro/HB4yzqatH5QbsaEsq-aS53FRLkpgefpogCLcB/s1600/quezon-tourist-spots.jpg",
                933.3,
                -12.33,
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 2",
                "https://1.bp.blogspot.com/-Zs-4id83c3o/WKjVMMKPliI/AAAAAAAAErg/1v61K2iVLs0QIgtTwV0fZNUx8IBf5FL4QCLcB/s640/quezon-tourist-destinations.JPG",
                933.3,
                -12.33,
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 3",
                "https://1.bp.blogspot.com/-EGxAWWce0tU/WKjWV2XkRSI/AAAAAAAAEr0/xNXenrvWxGUE7xBR9QYzalWlnjXfXJppgCLcB/s640/mt-cristobal.JPG",
                933.3,
                -12.33,
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 4",
                "https://2.bp.blogspot.com/-VmT8cnTLFSM/WKjVOIMymPI/AAAAAAAAEro/HB4yzqatH5QbsaEsq-aS53FRLkpgefpogCLcB/s1600/quezon-tourist-spots.jpg",
                933.3,
                -12.33,
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 5",
                "https://1.bp.blogspot.com/-Zs-4id83c3o/WKjVMMKPliI/AAAAAAAAErg/1v61K2iVLs0QIgtTwV0fZNUx8IBf5FL4QCLcB/s640/quezon-tourist-destinations.JPG",
                933.3,
                -12.33,
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        return attractions;
    }
}
