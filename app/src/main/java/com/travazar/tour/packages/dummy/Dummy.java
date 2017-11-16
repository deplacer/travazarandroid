package com.travazar.tour.packages.dummy;

import com.travazar.tour.packages.data.model.Attraction;
import com.travazar.tour.packages.data.model.Destination;
import com.travazar.tour.packages.data.model.PriceOption;
import com.travazar.tour.packages.data.model.Slider;
import com.travazar.tour.packages.data.model.TourPackage;
import com.travazar.tour.packages.data.model.base.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kali_root on 10/13/2017.
 */

public class Dummy {
    public static List<Slider> getFeatures() {
        List<Slider> features = new ArrayList<>();
        features.add(Slider.builder().imageUrl("http://aws-cdn-01.shemazing.ie/wp-content/uploads/2015/09/tower_2.jpg").build());
        features.add(Slider.builder().imageUrl("https://www.vigattintourism.com/assets/tourist_spots_photos/optimize/13434614573sUQ7Z2J.jpg").build());
        features.add(Slider.builder().imageUrl("https://philippinescities.com/wp-content/uploads/2013/05/tarshier-bohol.jpg").build());
        return features;
    }

    public static List<Attraction> getTopAttractions() {
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction",
                "https://2.bp.blogspot.com/-VmT8cnTLFSM/WKjVOIMymPI/AAAAAAAAEro/HB4yzqatH5QbsaEsq-aS53FRLkpgefpogCLcB/s1600/quezon-tourist-spots.jpg",
                9.8150789,
                124.1958745,
                4.5,
                "2,300 reviews",
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 2",
                "https://1.bp.blogspot.com/-Zs-4id83c3o/WKjVMMKPliI/AAAAAAAAErg/1v61K2iVLs0QIgtTwV0fZNUx8IBf5FL4QCLcB/s640/quezon-tourist-destinations.JPG",
                9.8150789,
                124.2958745,
                4.5,
                "2,300 reviews",
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 3",
                "https://1.bp.blogspot.com/-EGxAWWce0tU/WKjWV2XkRSI/AAAAAAAAEr0/xNXenrvWxGUE7xBR9QYzalWlnjXfXJppgCLcB/s640/mt-cristobal.JPG",
                9.8150789,
                124.3958745,
                4.5,
                "2,300 reviews",
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 4",
                "https://2.bp.blogspot.com/-VmT8cnTLFSM/WKjVOIMymPI/AAAAAAAAEro/HB4yzqatH5QbsaEsq-aS53FRLkpgefpogCLcB/s1600/quezon-tourist-spots.jpg",
                9.5250789,
                124.3958745,
                4.5,
                "2,300 reviews",
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        attractions.add(Attraction.create(
                1,
                "Dummy Attraction 5",
                "https://1.bp.blogspot.com/-Zs-4id83c3o/WKjVMMKPliI/AAAAAAAAErg/1v61K2iVLs0QIgtTwV0fZNUx8IBf5FL4QCLcB/s640/quezon-tourist-destinations.JPG",
                9.8350789,
                124.6958745,
                4.5,
                "2,300 reviews",
                "Philippines", "", "Bohol", "Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region."
        ));
        return attractions;
    }

    public static List<Slider> getTourDestinations() {
        List<Slider> destinations = new ArrayList<>();
        destinations.add(Slider.builder().name("Dummy destination 1").imageUrl("http://aws-cdn-01.shemazing.ie/wp-content/uploads/2015/09/tower_2.jpg").build());
        destinations.add(Slider.builder().name("Dummy destination 2").imageUrl("https://www.vigattintourism.com/assets/tourist_spots_photos/optimize/13434614573sUQ7Z2J.jpg").build());
        destinations.add(Slider.builder().name("Dummy destination 3").imageUrl("https://philippinescities.com/wp-content/uploads/2013/05/tarshier-bohol.jpg").build());
        return destinations;
    }

    public static TourPackage getTourPackage() {
        return TourPackage.builder()
                .tourPackageId(1)
                .tourOperatorId(1)
                .coverImageUrl("https://d1sttufwfa12ee.cloudfront.net/uploads/deal/thumb/6878.jpg")
                .tourOperatorName("Bohol Travel & Tours")
                .title("Affordable Bohol Countryside Whole Day Tour")
                .additionalInfo("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .available(true)
                .shortDescription("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .description("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .location("Carmen, Bohol, Philippines")
                .priceOptions(getPriceOptions())
                .destinations(getDestinations())
                .rating(4.5)
                .tourCode("23d3FDdf")
                .totalReviews("451 Reviews")
                .departurePoint("Tagbilaran Plaza")
                .departureTime("8 AM")
                .returnTime("5 PM")
                .duration("8 Hours")
                .build();
    }

    public static List<TourPackage> getTourPackages() {
        List<TourPackage> tourPackages = new ArrayList<>();
        TourPackage tourPackage = TourPackage.builder()
                .tourPackageId(1)
                .tourOperatorId(1)
                .coverImageUrl("https://d1sttufwfa12ee.cloudfront.net/uploads/deal/thumb/6878.jpg")
                .tourOperatorName("Bohol Travel & Tours")
                .title("Affordable Bohol Countryside Whole Day Tour")
                .additionalInfo("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .available(true)
                .description("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .shortDescription("The Schutzstaffel (SS; also stylized as Runic \"ᛋᛋ\" with Armanen runes; German pronunciation: [ˈʃʊtsˌʃtafl̩] (About this sound listen); literally \"Protection Squadron\") was a major paramilitary organization under Adolf Hitler and the Nazi Party (NSDAP) in Nazi Germany, and later throughout German-occupied Europe during World War II. It began with a small guard unit known as the Saal-Schutz (Hall-Protection) made up of NSDAP volunteers to provide security for party meetings in Munich. In 1925, Heinrich Himmler joined the unit, which had by then been reformed and given its final name. ")
                .location("Carmen, Bohol, Philippines")
                .priceOptions(getPriceOptions())
                .destinations(getDestinations())
                .rating(4.5)
                .tourCode("23d3FDdf")
                .totalReviews("451 Reviews")
                .departurePoint("Tagbilaran Plaza")
                .departureTime("8 AM")
                .returnTime("5 PM")
                .duration("8 Hours")
                .build();
        for (int i = 0; i < 10; i++) {
            tourPackages.add(tourPackage);
        }
        return tourPackages;
    }

    private static List<Destination> getDestinations() {
        List<Destination> destinations = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            destinations.add(Destination.builder()
                    .tourPackageId(1)
                    .attraction(getTopAttractions().get(i - 1))
                    .daySequence("Day 1")
                    .destinationId(i)
                    .notes("Quezon is one of the provinces near Manila with a lot of tourist destinations to offer, either mountains, water and historical landmarks. It is very accessible because transportation is much easier and travel period is 2 to 3 hours. It is still part of southern Luzon region.")
                    .time(i + " pm")
                    .build()
            );
        }
        return destinations;
    }

    private static List<PriceOption> getPriceOptions() {
        List<PriceOption> priceOptions = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            priceOptions.add(PriceOption.builder()
                    .numberOfPerson(i)
                    .priceOptionId(i)
                    .tourPackageId(1)
                    .price(Price.builder()
                            .price(1200.00 + (i + 100))
                            .currency("P")
                            .displayAmount("1," + i + "00.00")
                            .build())
                    .build());
        }
        return priceOptions;
    }
}
