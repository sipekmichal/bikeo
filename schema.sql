-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Database: bikeo
-- ------------------------------------------------------
-- Server version	5.6.29



--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `enabled` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Category`
--

INSERT INTO `Category` VALUES (1,'Cross Country',1),(2,'Downhill',1),(3,'Road cycling',1),(4,'Freestyle',1),(5,'BMX',1);

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `enabled` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1);

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` int(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` VALUES (52,'admin@admin.cz',1,'admin','$2a$10$QQRQ3ffYMtyaVIyMmYsVleDDgOSlau9OTGm5Q6lTqHbl7KWn0kN7i'),(53,'michal@sipek.cz',1,'michalsipek','$2a$10$cO34wif7HtEP69fyeg62qOAqcO1MWI.9ot8lfoVgzAm8BJKVC5UF6'),(54,'mara.pivo@seznam.cz',1,'Pivoman','$2a$10$7cnP6PnHJsA7CMwsWwuwDuQbyEfZC3ubXwqBU7ugi3RIhdRKCymDa');

--
-- Table structure for table `Video`
--

CREATE TABLE `Video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1048) CHARACTER SET utf8 DEFAULT NULL,
  `enabled` int(2) NOT NULL,
  `publishDate` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `yid` varchar(255) NOT NULL,
  `confirmed` varchar(45) NOT NULL,
  `views` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ED245B7368B71` (`user_id`),
  CONSTRAINT `FK4ED245B7368B71` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
--
-- Dumping data for table `Video`
--

INSERT INTO `Video` VALUES (39,'<p>o behind the scenes of the film - <a class=\" yt-uix-sessionlink \" href=\"http://www.youtube.com/playlist?list=PLO2LyhIJ_3OlDwcDgyb1siCH2VKaSZXXT\" data-url=\"http://www.youtube.com/playlist?list=PLO2LyhIJ_3OlDwcDgyb1siCH2VKaSZXXT\" data-sessionlink=\"itct=CC8Q6TgiEwjH0Ina5YDRAhUJF8MKHdvDBXUo-B0\">http://www.youtube.com/playlist?list=...</a><br /><br />The Ridge is the brand new film from Danny Macaskill...</p>',1,'2016-12-19 18:36:37','Danny Macaskill: The Ridge','https://www.youtube.com/v/xQ_IQS3VKjA',52,'xQ_IQS3VKjA','1','4'),(41,'<p>Relax, sit back and enjoi!</p>',1,'2016-12-19 18:40:27','Danny Macaskill The Ridge','https://www.youtube.com/v/vtt6p5VP2r0',52,'vtt6p5VP2r0','1','1'),(42,'<p>My favourite!</p>',1,'2016-12-19 18:44:20','Best of Danny Macaskill HD','https://www.youtube.com/v/uHHCRyKii2I',52,'uHHCRyKii2I','1','1'),(48,'<p>History about cross country bikes...</p>',1,'2016-12-19 20:18:01','Retro Vs Modern – The Cross Country Mountain Bike Race','https://www.youtube.com/v/FoEdy_Vy_V4',54,'FoEdy_Vy_V4','1','2'),(49,'<p>The bravest and best downhill mountain bikers descended upon Dan Atherton&rsquo;s notorious Hardline course in the remote Welsh mountains for an epic display of mountain bike progression and racing. In short, this course is F***ing crazy. Steep drops, technical rock gardens, monster road gaps... the list of gnarly features goes on, but when the world\'s best come together to race on the track, there\'s no doubt the turnout and action will be epic. Take an in depth look at one of the most insane mountain bike events to ever go down, Red Bull Hardline.</p>',1,'2016-12-19 20:50:51','HardLine 2016 celý závod','https://www.youtube.com/v/PILHXklRcyI',54,'PILHXklRcyI','1','0'),(50,'<p>Claudio Caluori is back for another POV track ride-through down the UCI Mountain Bike World Cup track in Fort William, Scotland. Ride along as he blazes through the Scottish Countryside, boosting off big jumps and flying down some gorgeous single track!</p>',1,'2016-12-19 20:53:00','Downhill ve Skotsku','https://www.youtube.com/v/igp9sJkuAnU',54,'igp9sJkuAnU','1','0'),(51,'<p>We came down to South Africa for the Cape Argus Tour. It is the biggest cycling event in the world, probably.<br />On Friday, to stretch out the legs we went on pre-race ride [~130km why not?] to the Cape of Good Hope [I love this name!]. The road by the ocean side was quiet and a lille deserted. <br /><br />Suddenly, I spotted a white ostrich on my left, then this beast jumped on the road from the right and started chasing my friends! It was a little scary at first, but then I thought I gonna fell of my bike from laughter. The ostrich didn\'t have any problem to keep up at 50km/h and apparently they do 70km/h with no sweat. <br /><br />Luckily the creature decided to leave us alone, as we were running out of road. The Cape of Good hope is a dead end way.<br /><br />My guess he wanted to show off in front of his girlfriend, i bet she was very impressed!</p>',1,'2016-12-19 20:57:53','Pštros honí cyklisty na silnici','https://www.youtube.com/v/kotWv4MCxNI',54,'kotWv4MCxNI','1','0'),(52,'',1,'2016-12-19 21:03:09','Peter Sagan - The highlights of season 2014','https://www.youtube.com/v/NHM6JtEdHp8',54,'NHM6JtEdHp8','1','0'),(53,'<p>I got to work with some of the best Trials bikers in the country take on the City by the Bay in the Fusion Energi and CMAX Energi. In cars powered by battery and gas, these bike-ridingthrill-seekers go further than you can imagine with the help of a company that is all about MPG AND <a class=\" yt-uix-servicelink \" href=\"http://www.ford.com/\" target=\"_blank\" rel=\"nofollow\" data-servicelink=\"CC8Q6TgiEwiAj8PJhoHRAhXDShYKHXI6CpMo-B0\" data-url=\"http://www.ford.com\">http://www.ford.com</a><br /><br />Super thanks to Ford for making this video happen! Video wouldn\'t have been possible without Ford, and the amazing athletes we got to work with.</p>',1,'2016-12-19 21:05:02','Jak se jezdí v San Franciscu','https://www.youtube.com/v/K9XCKP9KN7A',54,'K9XCKP9KN7A','1','0'),(54,'<p>nice bmx video part of street and ramp shredder mike miller.</p>',1,'2016-12-19 21:14:02','BMX STREET: MIKE MILLER','https://www.youtube.com/v/PiAgKwSjJ1M',54,'PiAgKwSjJ1M','1','0'),(55,'<p>FLAT ARK 2016 (BMX FLAT LAND WORLD CHIAMPIONSHIP)<br />FINAL BATTLE<br />Yohei Uchino VS Matthias Dandois</p>',1,'2016-12-19 21:15:00','FLAT ARK 2016 \"FINAL BATTLE\" Yohei Uchino VS Matthias Dandois','https://www.youtube.com/v/3YeVgaQraDk',54,'3YeVgaQraDk','1','0');

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK143BF46A620BC791` (`role_id`),
  KEY `FK143BF46A7368B71` (`user_id`),
  CONSTRAINT `FK143BF46A620BC791` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`),
  CONSTRAINT `FK143BF46A7368B71` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` VALUES (52,1),(53,2),(54,1);

--
-- Table structure for table `video_category`
--

CREATE TABLE `video_category` (
  `video_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `FKA3D7B442B2FF7711` (`category_id`),
  KEY `FKA3D7B44234225D23` (`video_id`),
  CONSTRAINT `FKA3D7B44234225D23` FOREIGN KEY (`video_id`) REFERENCES `Video` (`id`),
  CONSTRAINT `FKA3D7B442B2FF7711` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `video_category`
--

INSERT INTO `video_category` VALUES (39,1),(41,4),(42,4),(48,1),(49,2),(50,2),(51,3),(52,3),(53,4),(54,5),(55,5);

-- Dump completed on 2016-12-19 21:53:14
