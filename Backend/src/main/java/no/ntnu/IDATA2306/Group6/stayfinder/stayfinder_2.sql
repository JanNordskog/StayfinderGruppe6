-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: 21. Mai, 2024 20:02 PM
-- Tjener-versjon: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stayfinder`
--

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `agencies`
--

CREATE TABLE `agencies` (
  `agencyID` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `website` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `agencies`
--

INSERT INTO `agencies` (`agencyID`, `name`, `email`, `phone_number`, `website`) VALUES
('agency1', 'Wanderlust World', 'contact@wanderlustworld.com', '555-0101', 'http://wanderlustworld.com'),
('agency10', 'Oceanic Odyssey', 'reservations@oceanicodyssey.com', '555-1010', 'http://oceanicodyssey.com'),
('agency11', 'Highland Hikes', 'contact@highlandhikes.com', '555-1111', 'http://highlandhikes.com'),
('agency12', 'Urban Utopia Excursions', 'hello@urbanutopia.com', '555-1212', 'http://urbanutopia.com'),
('agency2', 'GlobeTrotters Inc.', 'info@globetrottersinc.com', '555-0202', 'http://globetrottersinc.com'),
('agency3', 'Adventure Awaits Travel', 'hello@adventureawaits.com', '555-0303', 'http://adventureawaits.com'),
('agency4', 'Serenity Vacations', 'support@serenityvacations.com', '555-0404', 'http://serenityvacations.com'),
('agency5', 'Explorer\'s Eden', 'bookings@explorerseden.com', '555-0505', 'http://explorerseden.com'),
('agency6', 'Nomadic Narratives', 'contact@nomadicnarratives.com', '555-0606', 'http://nomadicnarratives.com'),
('agency7', 'Azure Adventures', 'info@azureadventures.com', '555-0707', 'http://azureadventures.com'),
('agency8', 'Cosmic Getaways', 'support@cosmicgetaways.com', '555-0808', 'http://cosmicgetaways.com'),
('agency9', 'Time Travel Tours', 'book@timetraveltours.com', '555-0909', 'http://timetraveltours.com');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `agencies_seq`
--

CREATE TABLE `agencies_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `agencies_seq`
--

INSERT INTO `agencies_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `favorites`
--

CREATE TABLE `favorites` (
  `favoriteid` int(11) NOT NULL,
  `listingid` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotelimages`
--

CREATE TABLE `hotelimages` (
  `imageID` varchar(255) NOT NULL,
  `hotelID` varchar(255) NOT NULL,
  `grade` int(11) NOT NULL,
  `source_link` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `hotelimages`
--

INSERT INTO `hotelimages` (`imageID`, `hotelID`, `grade`, `source_link`) VALUES
('img1', 'hotel1', 2, 'http://localhost:8080/api/get/image/andante_hotel.png'),
('img10', 'hotel10', 2, 'http://localhost:8080/api/get/image/The_thief.png'),
('img11', 'hotel11', 2, 'http://localhost:8080/api/get/image/hotel-bristol.jpg'),
('img12', 'hotel12', 2, 'http://localhost:8080/api/get/image/Marina_bay_sand.png'),
('img2', 'hotel2', 2, 'http://localhost:8080/api/get/image/thon_hotel_ålesud.jpg'),
('img3', 'hotel3', 2, 'http://localhost:8080/api/get/image/scandic_parken.jpg'),
('img4', 'hotel4', 2, 'http://localhost:8080/api/get/image/carlton_tower_hotel.jpg'),
('img5', 'hotel5', 2, 'http://localhost:8080/api/get/image/Swissôtel_Amsterdam.jpg'),
('img6', 'hotel6', 2, 'http://localhost:8080/api/get/image/Hotel_Homs.jpg'),
('img7', 'hotel7', 2, 'http://localhost:8080/api/get/image/Radisson_Blu_Atlantic Hotel_Stavanger.jpg'),
('img8', 'hotel8', 2, 'http://localhost:8080/api/get/image/Clarion_Hotel_The_Hub_Oslo.png'),
('img9', 'hotel9', 2, 'http://localhost:8080/api/get/image/Grand_Hotel_Terminus_Bergen.png'),
('The_thief2.png', 'hotel10', 1, 'http://localhost:8080/api/get/image/The_thief2.png');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotelimages_seq`
--

CREATE TABLE `hotelimages_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `hotelimages_seq`
--

INSERT INTO `hotelimages_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotels`
--

CREATE TABLE `hotels` (
  `hotelID` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `website` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `location_type` varchar(255) NOT NULL,
  `room_type_available` varchar(255) NOT NULL,
  `extra_features` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `hotels`
--

INSERT INTO `hotels` (`hotelID`, `name`, `address`, `website`, `phone_number`, `location_type`, `room_type_available`, `extra_features`, `description`) VALUES
('hotel1', 'Andante Hotel', 'City Center Address', 'http://andantehotel.com', '000-000-0001', 'City Center', 'Single', 'Complimentary Wi-Fi, Rooftop Pool, 24-hour Gym Access', 'Check into the Andante Hotel, where ‘slow and steady’ doesn’t win the race—it redefines it. Right in the heartbeat of the city center, this hotel is so conveniently located that you might just think we bribed city planners. With Single rooms that are perfect for the solo traveler or the lone wolf who just needs a break from the pack, you’ll find a haven that’s tailor-made just for you.\n\nOur complimentary Wi-Fi is so fast, you’ll feel guilty about not paying for it. Stream, surf, and Zoom to your heart’s content—buffering is for other hotels, not Andante. Plus, with access to our 24-hour gym, you can work out on your schedule, because who wants to adjust their sleep cycle just to fit in a treadmill session?\n\nBut wait, there’s more! Our rooftop pool isn’t just a pool. It’s an urban oasis that looks so good you’ll swear it\'s photoshopped. Swim laps or just float and gloat at the stunning city views. It’s the perfect spot to chill out, or heat things up with some of the coolest Instagram selfies that’ll make your friends wish they were there.\n\nAt Andante Hotel, we take ‘chill’ seriously. It’s not just a temperature; it’s a lifestyle. Whether you’re here for business, pleasure, or a little bit of both, we provide a laid-back atmosphere that lets you set the pace. Come for the amenities, stay for the experience—Andante Hotel is where slow and steady wins your heart.'),
('hotel10', 'The Thief, Oslo', 'Waterfront/Urban Oslo Address', 'http://thethiefoslo.com', '000-000-0010', 'Waterfront/Urban', 'Artist, Premium, Suite', 'Spa, Waterfront Views, Art Decor', 'Welcome to The Thief, Oslo’s most ‘criminal’ luxury hotel, where you’re encouraged to steal away from your regular life for a getaway that’s seriously on the waterfront of fabulous. Located in Oslo’s hippest district, this hotel isn’t just on the waterfront—it practically invents it. With rooms like the Artist, Premium, and Suite, you’ll be living so large, you might just feel guilty.\n\nSleep like a master thief in beds so comfortable you’d swear they were stolen from the gods. Our rooms offer not just privacy, but a den of decadence complete with art decor that’s so engaging, it might just pickpocket your attention for hours.\n\nThe Spa at The Thief will rob you of your stresses, smuggling them away as you indulge in treatments that are downright felonious in their luxury. And let’s talk about the waterfront views—they’re so stunning, you’ll want to embezzle them for your Instagram.\n\nAs for dining, we promise to pilfer your palate with flavors so vibrant, they could be accused of grand theft aroma. Every meal is a heist of high culinary art, executed with the precision of a skilled cat burglar.\n\nAt The Thief, we’ve taken \'art theft\' to a new level, curating an atmosphere that’s part gallery, part getaway. It’s the only place where you can legitimately say, ‘Honey, I accidentally absconded with a masterpiece of an experience!’\n\nSo, if you’re looking for a place that takes the ‘con’ out of concierge and turns it into ‘confidence,’ your search ends here. Escape to The Thief, and let us steal your heart.'),
('hotel11', 'Hotel Bristol, Oslo', 'Historic Center Oslo Address', 'http://hotelbristoloslo.com', '000-000-0011', 'Historic Center', 'Classic Room, Deluxe Room, Suite', 'Library Bar, Afternoon Tea, Fitness Room', 'Enter the realm of Hotel Bristol in Oslo—a place where history isn\'t just remembered, it\'s provocatively celebrated. Nestled in the heart of Oslo\'s historic center, Hotel Bristol offers an escape not just from the mundane, but from the modern world\'s relentless push for novelty. Here, the past clings to every chandelier and whispers through the Library Bar, where the spirits aren’t just in the bottles.\n\nChoose your sanctuary—Classic Room, Deluxe Room, or Suite—and prepare to sleep among secrets old as time. Each room serves as a reminder of a more genteel era, daring you to disconnect from the digital rush and reconnect with a past that still echoes through the hallways.\n\nStep into the Library Bar, where every cocktail has a backstory as rich as the leather-bound classics that line the walls. This isn\'t just a place to drink; it\'s a place to debate, to engage, to challenge the status quo. It\'s where intellectuals of the past would feel at home arguing over the great issues of their day.\n\nIndulge in our Afternoon Tea, an affair that rebels against the fast-food culture, slowing down time so you can savor every bite and every sip, steeped in tradition yet deliciously defiant of the modern calorie counting craze.\n\nEven our Fitness Room offers more than just a workout—it provides a space to wrestle with your thoughts as much as your muscles, challenging the body to strengthen the mind.\n\nHotel Bristol isn’t just a place to stay. It\'s a controversial statement in a world racing towards the future. Here, we dare to pause, reflect, and luxuriate in the controversies and complexities of history. Are you bold enough to join us?'),
('hotel12', 'Marina Bay Sands', 'Waterfront/City Center Singapore Address', 'http://marinabaysands.com', '000-000-0012', 'Waterfront/City Center', 'Deluxe, Premier, Club Room', 'Infinity Pool, SkyPark, Luxury Shopping', 'Step into the high life at Marina Bay Sands, Singapore’s most iconic luxury playground. This isn’t just a hotel; it’s a hotspot where the elite come to play and the daring come to stay. Located at the pulse of Singapore’s waterfront and city center, this dazzling destination offers rooms like Deluxe, Premier, and Club Room that aren’t just about sleep—they’re about indulgence in every sense.\n\nDive into the legendary Infinity Pool, perched high above the city’s skyline, where the views are as breathtaking as the company you’ll keep. This isn’t just a swim; it’s an opportunity to float on top of the world, with a cocktail in hand and the city’s lights twinkling like stars below.\n\nElevate your stay with a visit to the SkyPark, a vantage point that’s not just about sightseeing, but about being seen. Whether you’re snapping selfies or stealing scenes, this is where you can rub shoulders with the movers and shakers who dictate the city’s beat.\n\nAnd when it’s time to shop, prepare for a spree like no other at our array of luxury boutiques. This isn’t shopping; it’s treasure hunting in a chic haven where your every fashion fantasy can come true.\n\nAt Marina Bay Sands, every moment is an escapade, every corner a new temptation. So, leave your inhibitions at the door and let yourself dive into the allure of Singapore’s most seductive address. After all, what happens at Marina Bay Sands might just make you want to stay forever.'),
('hotel2', 'Thon Hotel Ålesund', 'Coastal/Fjord View Address', 'http://thonhotelalesund.com', '000-000-0002', 'Coastal/Fjord View', 'Superior', 'Free Breakfast, Fjord View Rooms, Conference Facilities', 'Welcome to Thon Hotel Ålesund, where the rules of ordinary travel dissolve and adventure begins. Perched on the edge of the spectacular Norwegian coast, this hotel isn\'t just a place to stay—it\'s your front row seat to the majestic drama of the fjords. Each Superior room boasts mesmerizing views that challenge the boundaries between the surreal and the real, ensuring every moment of your stay is steeped in awe.\n\nStart your day with a bang, not a whimper, with our complimentary breakfast. Forget the standard fare; our spread is a feast for the senses, loaded with local delicacies and bold flavors that prepare you for the day ahead. And when it comes to rooms, think less sleeping space, more viewing platform for nature’s greatest hits, all from the comfort of your designer bed.\n\nNeed to mix business with pleasure? Our conference facilities are not just about ergonomic chairs and high-speed WiFi. They\'re venues where ideas can soar, inspired by the limitless views of the fjord. Here, creativity is not just welcomed; it’s demanded.\n\nAt Thon Hotel Ålesund, we don’t just offer a stay—we promise an immersion into the wild heart of Ålesund, wrapped in the luxury of a hotel that dares to be different. Come for the views, stay for the experience. This isn’t just any hotel; it’s a lifestyle choice for those who crave the extraordinary.'),
('hotel3', 'Scandic Parken', 'Park Proximity Address', 'http://scandicparken.com', '000-000-0003', 'Park Proximity', 'Standard, Plus, Premium', 'In-house Restaurant, Meeting Rooms, EV Charging Stations', 'Discover the serenity and convenience of Scandic Parken, perfectly located adjacent to a beautiful park, offering a peaceful retreat in the midst of the city’s hustle. This hotel is designed to provide comfort and convenience for travelers seeking quality and value in their accommodation choices. With a variety of room types, including Standard, Plus, and Premium, each guest can find the perfect space to suit their needs, styled with modern decor and thoughtful amenities.\n\nDine in style at our in-house restaurant, where every meal is an opportunity to explore local flavors and international favorites, all prepared with high-quality ingredients. The restaurant offers a welcoming atmosphere, ideal for a casual meal or an important business lunch.\n\nBusiness travelers will appreciate our versatile Meeting Rooms, equipped with the latest technology to facilitate productive sessions. Whether hosting a small meeting or a large conference, our facilities are adaptable to your event needs, providing the perfect setting for success.\n\nAdditionally, Scandic Parken is committed to sustainability, offering Electric Vehicle (EV) Charging Stations to accommodate guests who prioritize eco-friendly travel options. This feature ensures that those arriving by electric car can enjoy a convenient and seamless stay.\n\nAt Scandic Parken, we blend comfort, convenience, and thoughtful amenities to create a stay that’s as relaxing as it is efficient. Whether you’re visiting for business or leisure, you’ll find everything you need for a delightful and satisfying experience.'),
('hotel4', 'Carlton Tower Hotel', 'Urban Location Address', 'http://carltontower.com', '000-000-0004', 'Urban', 'Deluxe, Executive Suite', 'Spa Services, Gourmet Dining, Limousine Service', 'Escape to the epitome of urban luxury at the Carlton Tower Hotel, situated in a vibrant urban location that is perfect for discovering the city\'s dynamic culture and nightlife. This exquisite hotel is designed to offer an unparalleled experience of elegance and sophistication for discerning travelers seeking premium accommodations and exclusive amenities.\n\nGuests can choose from deluxe rooms and executive suites, each crafted with opulent decor and outfitted with the latest in comfort and technology. The rooms are havens of tranquility, providing a luxurious space to relax and rejuvenate after a busy day exploring the city.\n\nIndulge in the ultimate relaxation experience with our full-service Spa, offering a wide range of treatments designed to pamper your body and soothe your spirit. From rejuvenating facials to therapeutic massages, our expert spa therapists ensure every experience is tailored to your personal needs.\n\nCulinary enthusiasts will delight in our Gourmet Dining options, where each dish is a masterpiece of flavor, crafted by renowned chefs using only the finest ingredients. Our restaurants offer a sophisticated atmosphere that is perfect for a romantic dinner, a business lunch, or a special celebration.\n\nEnhance your stay with the convenience and luxury of our Limousine Service. Whether you need a stylish ride to a corporate event or a leisurely tour around the city, our fleet of high-end vehicles and professional drivers are at your disposal.\n\nAt the Carlton Tower Hotel, every detail of your stay is meticulously curated to ensure an unforgettable experience of luxury, comfort, and personalized service.'),
('hotel5', 'Swissôtel Amsterdam', 'City Center Amsterdam', 'http://swissotelamsterdam.com', '000-000-0005', 'City Center', 'Classic', 'Fitness Center, Bicycle Rental, Business Center', 'Experience the vibrant heart of the city at Swissôtel Amsterdam, a contemporary haven of elegance and comfort located right in the bustling City Center of Amsterdam. This premier hotel offers guests an exemplary stay with a touch of Swiss hospitality and a focus on impeccable service and sophisticated style.\n\nEach Classic room at Swissôtel Amsterdam is designed to provide guests with a serene and stylish retreat from the city\'s lively pace. Furnished with modern amenities and luxurious comforts, the rooms serve as the perfect base for both leisure and business travelers.\n\nEnhance your stay with our state-of-the-art Fitness Center, equipped with the latest exercise equipment for maintaining your workout routine while traveling. For those looking to explore the city in a more leisurely fashion, take advantage of our Bicycle Rental service. Amsterdam is famously bike-friendly, and there’s no better way to navigate the picturesque streets and canals than on two wheels.\n\nBusiness travelers will appreciate the convenience of our comprehensive Business Center. Whether you need to host a meeting, catch up on work, or connect with colleagues, our facilities are designed to support all your professional needs.\n\nSwissôtel Amsterdam combines the tranquility of Swiss precision with the charm of Dutch hospitality, making it an ideal choice for those seeking a refined and comfortable stay in the heart of Amsterdam.'),
('hotel6', 'Hotel Homs', 'Historic Center Address', 'http://hotelhoms.com', '000-000-0006', 'Historic Center', 'Standard, Junior Suite, Suite', 'Mini Bar, Private Terrace, Babysitting Service', 'Discover the charm and sophistication of Hotel Homs, nestled in the heart of the historic center, where culture and comfort converge. This boutique hotel offers a unique stay amidst the rich tapestry of history, providing guests with an intimate escape in one of the city\'s most coveted locations. Guests can select from a variety of rooms including Standard, Junior Suite, and Suite, each furnished to reflect the hotel\'s elegant style while providing modern comforts and conveniences.\n\nIndulge in the luxury of your own Private Terrace, available in select accommodations, where you can enjoy tranquil mornings or serene evenings overlooking the vibrant cityscape. Each room is equipped with a Mini Bar, stocked with a selection of premium beverages and snacks, perfect for a relaxing night in or a convenient refreshment.\n\nAt Hotel Homs, we understand the importance of family travel, which is why we offer a comprehensive Babysitting Service that allows parents to explore the city\'s rich offerings with the assurance that their children are cared for by professional and attentive staff.\n\nHotel Homs is more than just a place to stay; it\'s a gateway to experience the historical and cultural delights of the city. Whether you are visiting for leisure or business, Hotel Homs combines the beauty of the past with the comforts of the present to ensure your stay is truly memorable.'),
('hotel7', 'Radisson Blu Atlantic Hotel, Stavanger', 'City Center with Lake View Address', 'http://radissonblustavanger.com', '000-000-0007', 'City Center with Lake View', 'Standard, Business Class, Suite', 'Complimentary Super Breakfast Buffet, Sky Bar, EV Charging', 'Immerse yourself in the refined elegance and serene beauty of the Radisson Blu Atlantic Hotel, located in the heart of Stavanger with enchanting views over the tranquil lake. This distinguished hotel is ideally situated to offer guests both the bustling city life and peaceful nature escapes. Choose from our well-appointed room selections including Standard, Business Class, and Suite accommodations, each designed to provide the utmost comfort and style for your stay.\n\nBegin each morning with our Complimentary Super Breakfast Buffet, a lavish spread that caters to all tastes and dietary needs with an array of fresh, high-quality ingredients. Elevate your evening experiences at our Sky Bar, where you can indulge in exclusive cocktails and breathtaking panoramic views of Stavanger’s skyline and the serene lake below.\n\nThe Radisson Blu Atlantic Hotel is perfect for both business and leisure travelers. Business guests will appreciate the enhanced amenities in our Business Class rooms, designed for productivity and relaxation. The hotel’s commitment to service and comfort ensures a memorable stay, with a focus on hospitality that anticipates your needs and desires.\n\nWhether you’re in town for business, a relaxing getaway, or a bit of both, the Radisson Blu Atlantic Hotel provides a perfect blend of modern luxury and classic charm, all within a picturesque setting that captures the best of Stavanger.'),
('hotel8', 'Clarion Hotel The Hub, Oslo', 'Urban Location Oslo', 'http://clarionhotelthehuboslo.com', '000-000-0008', 'Urban', 'Moderate, Standard, Superior', 'Rooftop Bar, Organic Breakfast, Eco-Friendly', 'Welcome to the Clarion Hotel The Hub, a premier destination where urban dynamism meets sustainable luxury in the heart of Oslo. This modern eco-friendly hotel not only offers a convenient central location but also serves as a gateway to all the vibrant experiences the city has to offer. From business travelers to leisure seekers, our hotel caters to every guest with a selection of room types including Moderate, Standard, and Superior, all designed with a blend of comfort and functionality.\r\n\r\nElevate your stay by visiting our exclusive Rooftop Bar, where you can enjoy panoramic views of the Oslo skyline while sipping on handcrafted cocktails in a chic and stylish setting. Begin each day with a commitment to wellness as you indulge in our organic breakfast, featuring a variety of nutritious, locally-sourced foods that cater to all tastes and dietary preferences.\r\n\r\nThe Clarion Hotel The Hub is committed to sustainability, integrating eco-friendly practices throughout the hotel to ensure a minimal environmental impact. This commitment is woven into the fabric of your stay, from energy-efficient room designs to eco-friendly amenities that enhance both your experience and the health of our planet.\r\n\r\nWhether you\'re visiting Oslo for business or leisure, the Clarion Hotel The Hub offers a uniquely modern and sustainable hotel experience, where every stay is characterized by premium hospitality and conscious living. Discover the rhythm of Oslo life from a place that cares about your well-being and the world around us.'),
('hotel9', 'Grand Hotel Terminus, Bergen', 'City Center Bergen Address', 'http://grandhotelterminusbergen.com', '000-000-0009', 'City Center', 'Classic, Deluxe, Grand Suite', 'Whisky Bar, Heritage Building, Afternoon Tea', 'Steeped in historical elegance, the Grand Hotel Terminus in Bergen offers a captivating blend of old-world charm and modern luxury. Located in the heart of the bustling city center, this heritage building is a timeless getaway just steps away from the vibrant street life and scenic attractions of Bergen. Guests can choose from a variety of tastefully appointed rooms, including the Classic, Deluxe, and Grand Suite, each offering a unique ambiance and exquisite comforts tailored to make your stay memorable.\r\n\r\nIndulge in the rich, inviting atmosphere of our renowned Whisky Bar, where connoisseurs and casual drinkers alike can savor an impressive collection of fine whiskies and spirits. The hotel\'s tradition of afternoon tea provides a delightful pause in the day, serving a selection of teas accompanied by an assortment of fresh, locally-sourced pastries and sandwiches, all in an environment that echoes the genteel traditions of yesteryears.\r\n\r\nAt the Grand Hotel Terminus, every detail of your experience is infused with the warmth and hospitality that has made our hotel a landmark destination for travelers. Whether you are visiting for business or pleasure, our dedicated staff ensures that your stay is both splendid and unforgettable. Explore the city\'s rich cultural tapestry or simply relax in the luxury of our historic premises—the choice is yours at the Grand Hotel Terminus, where heritage meets contemporary elegance.');

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotels_seq`
--

CREATE TABLE `hotels_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `hotels_seq`
--

INSERT INTO `hotels_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotel_images`
--

CREATE TABLE `hotel_images` (
  `imageid` varchar(255) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `hotelid` varchar(255) DEFAULT NULL,
  `source_link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `hotel_images_seq`
--

CREATE TABLE `hotel_images_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `hotel_images_seq`
--

INSERT INTO `hotel_images_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `listing`
--

CREATE TABLE `listing` (
  `listingid` varchar(255) NOT NULL,
  `hotelID` varchar(255) NOT NULL,
  `agencyID` varchar(255) NOT NULL,
  `open_date` date DEFAULT NULL,
  `closed_date` date DEFAULT NULL,
  `price` double NOT NULL,
  `imageid` varchar(255) DEFAULT NULL,
  `visible` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `listing`
--

INSERT INTO `listing` (`listingid`, `hotelID`, `agencyID`, `open_date`, `closed_date`, `price`, `imageid`, `visible`) VALUES
('1', 'hotel1', 'agency1', '2024-05-20', '2024-05-25', 150, 'img1', 1),
('10', 'hotel10', 'agency10', '2024-10-01', '2024-10-06', 2300, 'img10', 1),
('11', 'hotel11', 'agency11', '2024-06-15', '2024-06-20', 1600, 'img11', 1),
('12', 'hotel12', 'agency12', '2024-11-05', '2024-11-10', 500, 'img12', 1),
('2', 'hotel2', 'agency2', '2024-06-15', '2024-06-20', 1200, 'img2', 1),
('3', 'hotel3', 'agency3', '2024-07-01', '2024-07-05', 1100, 'img3', 1),
('4', 'hotel4', 'agency4', '2024-08-10', '2024-08-15', 250, 'img4', 1),
('5', 'hotel5', 'agency5', '2024-09-05', '2024-09-10', 180, 'img5', 1),
('6', 'hotel6', 'agency6', '2024-10-15', '2024-10-20', 100, 'img6', 1),
('7', 'hotel7', 'agency7', '2024-09-10', '2024-09-15', 950, 'img7', 1),
('8', 'hotel8', 'agency8', '2024-07-05', '2024-07-12', 1050, 'img8', 1),
('9', 'hotel9', 'agency9', '2024-08-20', '2024-08-25', 1200, 'img9', 1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `listing_seq`
--

CREATE TABLE `listing_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `listing_seq`
--

INSERT INTO `listing_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `credit_card` varchar(255) NOT NULL,
  `expiry_date` varchar(10) NOT NULL,
  `cvv` varchar(4) NOT NULL,
  `hotel_id` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `guests` int(11) NOT NULL,
  `arrival_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `orders`
--

INSERT INTO `orders` (`order_id`, `name`, `email`, `credit_card`, `expiry_date`, `cvv`, `hotel_id`, `destination`, `guests`, `arrival_date`, `departure_date`, `price`) VALUES
(3, 'avnit', 'avnit0203@gmail.com', '12345678910', '2024-12', '123', 'hotel1', 'City Center Address', 1, '2024-05-21', '2024-05-23', 150),
(19, 'avnit', 'avnit0203@gmail.com', '12345678910', '2024-12', '123', 'hotel10', 'Waterfront/Urban Oslo Address', 1, '2024-10-01', '2024-10-03', 2300),
(29, 'Avnit Singh', 'asanand@ntnu.no', '1234578', '2024-06', '123', 'hotel1', 'City Center Address', 1, '2024-05-21', '2024-05-25', 150),
(30, 'vnit', 'asanand@stud.ntnu.no', '12345678910', '2024-11', '123', 'hotel1', 'City Center Address', 1, '2024-05-21', '2024-05-25', 150),
(31, 'eirik', 'eirik.imrik@gmai.com', '658685', '2024-11', '865', 'hotel2', 'Coastal/Fjord View Address', 1, '2024-06-15', '2024-06-20', 1200),
(32, 'eiriiiiik', 'eirik.imrik@gmail.com', '123456789', '2024-12', '123', 'hotel11', 'Historic Center Oslo Address', 1, '2024-06-16', '2024-06-20', 1600);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `orders_seq`
--

CREATE TABLE `orders_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `orders_seq`
--

INSERT INTO `orders_seq` (`next_val`) VALUES
(33);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `review`
--

CREATE TABLE `review` (
  `reviewid` bigint(20) NOT NULL,
  `rate` int(11) DEFAULT NULL,
  `text_review` varchar(500) DEFAULT NULL,
  `listingid` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `review_seq`
--

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `review_seq`
--

INSERT INTO `review_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `userperm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `users`
--

INSERT INTO `users` (`userId`, `name`, `email`, `password`, `address`, `gender`, `phone`, `dob`, `userperm`) VALUES
(13, 'Avnit', 'avnit0203@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Fogd Greves veg 7', 'male', '2893298', '4545-03-13', 1),
(108, 'Jan', 'jan.nordskog@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Bekkedalsveien 7', 'female', '123', '2001-08-10', 0),
(109, 'løk', 'asanand@ntnu.no', '$2a$10$vt0bDfnq4F29iLAgqcQ7f.QFJa3z5DEXalSgOlLMUwkqOP9Afv0dK', 'Ntnuveien', 'male', '98232123', '2024-04-30', 0);

-- --------------------------------------------------------

--
-- Tabellstruktur for tabell `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dataark for tabell `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(111);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agencies`
--
ALTER TABLE `agencies`
  ADD PRIMARY KEY (`agencyID`);

--
-- Indexes for table `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`favoriteid`),
  ADD KEY `FKgh3i8tbidtv7o7ykqdcptat31` (`listingid`),
  ADD KEY `FKpa8vyme2tb5t10smfyikgyemg` (`userid`);

--
-- Indexes for table `hotelimages`
--
ALTER TABLE `hotelimages`
  ADD PRIMARY KEY (`imageID`),
  ADD KEY `HotelID` (`hotelID`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`hotelID`);

--
-- Indexes for table `hotel_images`
--
ALTER TABLE `hotel_images`
  ADD PRIMARY KEY (`imageid`),
  ADD KEY `FK9t6h5cbta0gbaokxt5g3hqen` (`hotelid`);

--
-- Indexes for table `listing`
--
ALTER TABLE `listing`
  ADD PRIMARY KEY (`listingid`),
  ADD KEY `FKqrn6urkdiys6jaje0y7gwha3v` (`agencyID`),
  ADD KEY `FK2lj7tuo2di2i9dk5fgeu81wjx` (`hotelID`),
  ADD KEY `FKoio04x1jdxu9wq32e0ygfwoaw` (`imageid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `fk_hotel` (`hotel_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`reviewid`),
  ADD KEY `FK2xq02bjghgj9bt3x6g3q8uy0v` (`listingid`),
  ADD KEY `FKr5b7ngwds9au4py4plwik2ojf` (`userid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `favorites`
--
ALTER TABLE `favorites`
  MODIFY `favoriteid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- Begrensninger for dumpede tabeller
--

--
-- Begrensninger for tabell `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `FKgh3i8tbidtv7o7ykqdcptat31` FOREIGN KEY (`listingid`) REFERENCES `listing` (`listingid`),
  ADD CONSTRAINT `FKpa8vyme2tb5t10smfyikgyemg` FOREIGN KEY (`userid`) REFERENCES `users` (`userId`);

--
-- Begrensninger for tabell `hotelimages`
--
ALTER TABLE `hotelimages`
  ADD CONSTRAINT `HotelID` FOREIGN KEY (`hotelID`) REFERENCES `hotels` (`hotelID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Begrensninger for tabell `hotel_images`
--
ALTER TABLE `hotel_images`
  ADD CONSTRAINT `FK9t6h5cbta0gbaokxt5g3hqen` FOREIGN KEY (`hotelid`) REFERENCES `hotels` (`hotelID`);

--
-- Begrensninger for tabell `listing`
--
ALTER TABLE `listing`
  ADD CONSTRAINT `FK2lj7tuo2di2i9dk5fgeu81wjx` FOREIGN KEY (`hotelID`) REFERENCES `hotels` (`hotelID`),
  ADD CONSTRAINT `FKoio04x1jdxu9wq32e0ygfwoaw` FOREIGN KEY (`imageid`) REFERENCES `hotelimages` (`imageID`),
  ADD CONSTRAINT `FKqrn6urkdiys6jaje0y7gwha3v` FOREIGN KEY (`agencyID`) REFERENCES `agencies` (`agencyID`);

--
-- Begrensninger for tabell `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotelID`);

--
-- Begrensninger for tabell `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK2xq02bjghgj9bt3x6g3q8uy0v` FOREIGN KEY (`listingid`) REFERENCES `listing` (`listingid`),
  ADD CONSTRAINT `FKr5b7ngwds9au4py4plwik2ojf` FOREIGN KEY (`userid`) REFERENCES `users` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
