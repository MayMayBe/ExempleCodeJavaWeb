drop table if exists ordershopline;
drop table if exists ordershop;
drop table if exists client;
drop table if exists address;
drop table if exists city;
drop table if exists promotion;
drop table if exists instrument;
drop table if exists equivalentcharacteristic;
drop table if exists equivalentcategory;
drop table if exists equivalentdescription;
drop table if exists model;
drop table if exists musicalcharacteristic;
drop table if exists category;
drop table if exists language;
drop table if exists brand;
drop table if exists country;
drop table if exists description;

create table country
(
	idcountry int not null auto_increment,
    countryname varchar(50) not null,
    constraint pk_country primary key (idcountry)
);

create table language
(
	idlanguage int not null auto_increment,
	namelanguage varchar(50) not null unique,
    constraint pk_language primary key (idlanguage)
);

create table musicalcharacteristic
(
	idtype int not null auto_increment, 
    constraint pk_musicalcharacteristic primary key (idtype)
);

create table category
(
	idcategory int not null auto_increment, 
    constraint pk_category primary key (idcategory)
);

create table description
(
	iddescription int not null auto_increment,
	constraint pk_description primary key (iddescription)
);

create table equivalentcharacteristic
(
	idequivalentcharacteristic int not null auto_increment, 
	idtype int not null, 
	idlanguage int not null,
	namecharacteristic varchar(50) not null,
	constraint pk_equivalentcharacteristic primary key (idequivalentcharacteristic),
	constraint fk_equivalentcharacteristictype foreign key(idtype) references musicalcharacteristic(idtype),
	constraint fk_equivalentcharacteristiclanguage foreign key(idlanguage) references language(idlanguage)
);

create table equivalentcategory
(
	idequivalentcategory int not null auto_increment,
	idcategory int not null,
    idlanguage int not null,
    namecategory varchar(50) not null,
    constraint pk_equivalentcategory primary key (idequivalentcategory),
    constraint fk_equivalentcategorycategory foreign key(idcategory) references category(idcategory),
    constraint fk_equivalentcategorylanguage foreign key (idlanguage) references language(idlanguage)
);

create table brand
(
	idbrand int not null auto_increment,
	namebrand varchar(50) not null unique,
	idcountry int not null,
	constraint pk_brand primary key (idbrand),
	constraint fk_brandcountry foreign key (idcountry) references country(idcountry)
);

create table model
(
	idmodel int not null auto_increment,
	namemodel varchar(50) not null, 
	fretless boolean not null,
	nbstrings int not null check(nbstrings > 0),
	price float not null check(price > 0),
	idbrand int not null,
    idtype int not null, 
    idcategory int not null, 
	iddescription int not null,
	constraint pk_model primary key (idmodel),
	constraint fk_modelbrand foreign key (idbrand) references brand(idbrand),
    constraint fk_instrumentcategory foreign key (idcategory) references category(idcategory),
    constraint fk_instrumenttype foreign key (idtype) references musicalcharacteristic(idtype),
	constraint fk_instrumentdescription foreign key (iddescription) references description(iddescription)
);

create table equivalentdescription
(
	idequivalentdescription int not null auto_increment,
	iddescription int not null, 
	idlanguage int not null,
	description varchar(450) not null,
	constraint pk_equivalentdescription primary key (idequivalentdescription),
	constraint fk_equivalentdescriptiondescription foreign key(iddescription) references description(iddescription),
	constraint fk_equivalentdescriptionlanguage foreign key(idlanguage) references language(idlanguage)
);

create table promotion
(
	idpromotion int auto_increment,
	idbrand int not null,
	datebeginning date not null,
	dateend date not null,
	percentagereduction float not null check(percentagereduction > 0),
	constraint pk_promotion primary key(idPromotion),
	constraint fk_promotionbrand foreign key(idbrand) references brand(idbrand),
    check (datebeginning < dateend)
);

create table client
(
	idclient int not null auto_increment,
	email varchar(50) not null unique,
    password varchar(65) not null, 
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    telephonenumber varchar(25) not null,
    mobilenumber varchar(25),
	streetname varchar(25) not null,
	streetnumber varchar(8) not null,
	zipcode varchar(8) not null,
    city varchar(50) not null,
    idcountry int not null,
    constraint pk_client primary key (idclient),
    constraint fk_clientcountry foreign key(idcountry) references country(idcountry)
);

create table ordershop
(
	numberordershop int not null auto_increment,
	dateordershop date not null,
	ordershopsent boolean not null,
	idclient int not null,
	typepayment varchar(20) not null,
	paymentdone boolean not null,
	constraint pk_ordershop primary key (numberordershop),
	constraint fk_ordershopclient foreign key(idclient) references client(idclient)
);

create table ordershopline
(
	idordershopline int not null auto_increment,
	numberline int not null,
	numberordershop int not null,
	quantity int not null,
	realprice float not null, 
	percentagediscount float not null,
	idModel int not null,
	constraint pk_lineordershop primary key(idordershopline),
	constraint fk_lineordershop foreign key(numberordershop) references ordershop(numberordershop),
	constraint fk_lineordershopinstrument foreign key(idModel) references model(idModel), 
	constraint unique_lineordershop unique key(numberline, numberordershop)
);

insert into language (namelanguage)
values

('fr'),
('en');

insert into country (countryname)
values 

('France'),
('Etats Unis'),
('Japon'),
('Belgique');

insert into musicalcharacteristic values (default),(default),(default);

insert into description values (default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default),(default);


insert into equivalentcharacteristic (idtype,idlanguage,namecharacteristic)
values
(1,1,'Électrique'),
(2,1,'Acoustique'),
(3,1,'Semi-acoustique'),
(1,2,'Electric'),
(2,2,'Acoustic'),
(3,2,'Semi acoustic');

insert into category values (default),(default),(default);

insert into equivalentcategory (idcategory,idlanguage,namecategory)
values
(1,1,'guitare'),
(2,1,'basse'),
(3,1,'ukulélé'),
(1,2,'guitar'),
(2,2,'bass'),
(3,2,'ukulele');

insert into brand (namebrand,idcountry)
values
('Lâg',1),
('Stagg',4),
('Yamaha',3),
('BC Rich',2),
('Fender',2),
('Paul Reed Smith',2),
('Schecter',2),
('Ibanez',3),
('Gibson',2);

insert into model (namemodel,fretless,nbstrings,price,idbrand,idCategory,idType,iddescription)
values
('Arkane 201',false,6,259,1,1,1, 1),
('Arkane 100',false,6,329,1,1,1, 2),
('Arkane 3000',false,7,2699,1,1,1, 3),
('Arkane 200',false,6,599,1,1,1, 4),
('Arkane 66',false,6,199,1,1,1, 5),

('Jazz gt black',false,6,352,2,1,1, 6),

('Revstar',false,6,999,3,1,1, 7),
('Pacifica',false,6,279,3,1,1, 8),
('SA2200',false,6,1899,3,1,1, 9),
('PA 311',false,6,349,3,1,1, 10),
('RGX220',false,6,399,3,1,1, 11),

('Mockingbird x',false,6,291,4,1,1, 12),
('Pro x custom',false,6,973,4,1,1, 13),
('Warlock',false,6,339,4,1,1, 14),
('Warbeast',false,6,599,4,1,1, 15),

('Modern',false,6,498,5,1,1, 16),
('FSR Classic',false,6,599,5,1,1, 17),
('Stratocaster',false,6,598,5,1,1, 18),
('Standard',false,6,626,5,1,1, 19),
('American Elite',false,6,1849,5,1,1, 20),
('American Special',false,6,999,5,1,1, 21),

('SE Custom 22',false,6,569,6,1,1, 22),
('SE Custom 24',false,6,995,6,1,1, 23),
('CE 24',false,6,2490,6,1,1, 24),
('SE Mark Holcomb',false,6,949,6,1,1, 25),
('S2 Singlecut',false,6,1799,6,1,1, 26),
('SE Zach Myers',false,6,588,6,1,1, 27),

('Omen 8',false,8,569,7,1,1, 28),
('Hellraiser',false,6,1299,7,1,1, 29),
('Omen 7',false,7,529,7,1,1, 30),
('Synyster',false,6,1145,7,1,1, 31),
('Damien Platinum',false,6,799,7,1,1, 32),
('Black Jack',false,6,1199,7,1,1, 33),

('GRG170DX',false,6,259,8,1,1, 34),
('Gio Mikro',false,6,199,8,1,1, 35),
('PS120SP',false,6,999,8,1,1, 36),
('RG421',false,6,329,8,1,1, 37),
('JEJMR',false,6,499,8,1,1, 38),
('GRG121DX',false,6,219,8,1,1, 39),

('Les Paul Standard',false,6,1595,9,1,1, 40),
('SG Special Heritage',false,6,555,9,1,1, 41),
('Midtown Standard',false,6,888,9,1,1, 42),
('Les Paul Less+',false,6,975,9,1,1, 43),
('Les Paul Traditional',false,6,1295,9,1,1, 44),
('Les Paul Deluxe',false,6,1222,9,1,1, 45),
('SG Standard',false,6,999,9,1,1, 46),

/*Ukulélés*/
('Mino Aka Koa',false,4,239,5,3,1, 47),
('Mino Aka',false,4,159,5,3,1, 48),
('Fender ukulele',false,4,199,5,3,1, 49),

/*Guitares Acoustiques*/

('CD-60',false,6,129,5,1,2, 50),
('CD60CE',false,6,244,5,1,2, 51),
('FG 800 M',false,6,229,3,1,2, 52),
('J-45 Standard',false,6,1910,9,1,2, 53),

/*Guitares semi acoustiques*/
('AS53-TF',false,6,299,8,1,3, 54),
('AS73-TBC',false,6,399,8,1,3, 55),
('SA2200',false,6,1899,3,1,3, 56),

/*Basses éléctriques*/
('AS Nate Mendel',false,4,1129,5,2,1, 57),
('SR305EBL-WK',false,5,349,8,2,1, 58),
('Deluxe Active Jazz Bass',false,4,1239,5,2,1, 59),
('SR306E-WK',false,6,399,8,2,1, 60),

/*Basses acoustiques*/
('CB-100CE',false,4,322,5,2,2, 61),
('AEB8E',false,4,429,8,2,2, 62),
('Kingman Bass SCE',false,4,499,5,2,2, 63),
('PCBE 12 MH OPN',false,4,239,8,2,2, 64);



insert into equivalentdescription(iddescription,idlanguage,description)
values
(1,2,"The Arkane 200 is equipped with two humbuckers from EMG and has an irreproachable finish. The experienced musician won't be mistaken with the Floyd Rose vibrato, high precision machine heads, locking nut, many elements that will confirm his choice."),
(1,1,"L'arkane 200 est équipée avec deux humbuckers EMG et a une finition irréprochable. Le musicien expérimenté ne sera pas trompé grâce au floyd rose, mécaniques très précises, beaucoup d'éléments qui confirmeront son choix."),
(2,2,"The Arkane improves upon a familiar body style with increased fingerboard access and exceptional playability. The A100 features a carved top body, 24 fret Rosewood fingerboard, fixed bridge system, and 2 Duncan Designed humbuckers pickups. Available in high gloss finishes."),
(2,1,"L'arkane se retrouve dans une famille de corps avec un excellent accès aux frettes et une jouabilité exceptionnelle. La A100 comprends un corps incurbé, 24 frettes, bridge fixé et deux humbuckers Duncan. Disponible en finition brillantes"),
(3,2,"Very attractive guitar, with savage look and wonderful class, straight out from Lâg made in France. To become an incredible onstage weapon for any exceptionnal guitarist."),
(3,1,"Terriblement féline, c’est une guitare sauvage avec un look extrême et une classe folle, qui bondit hors de l’atelier LÂG made in France. pour devenir sur scène, une arme absolue entre les mains d’un guitariste exceptionnel."),
(4,2,"The Arkane 200 is equipped with two humbuckers from EMG and has an irreproachable finish. The experienced musician won't be mistaken with the Floyd Rose vibrato, high precision machine heads, locking nut, many elements that will confirm his choice."),
(4,1,"Ses 2 Humbuckers EMG HZ et son vibrato Floyd Rose Special confèrent à l’Arkane 200 les qualités indispensables à cette guitare Metal, élégante comme une princesse."),
(5,1,"Après plus de trois décennies passées à l’écoute d’innombrables guitaristes Hard et Metal, Michel Lâg a su créer un modèle d’entrée de gamme répondant à toutes ses exigences."),
(5,2,"The Arkane improves upon a familiar body style with increased fingerboard access and exceptional playability. The A66 features a body with body confort, 24 fret Rosewood fingerboard, smooth tremolo system, and a versatile compliment of a single humbucker and 2 single coil pickups. All of these features add up to a highly capable electric guitar for beginners. Available in high gloss finishes."),

(6,1,"Guitare jazz motif tigré. Semi acoustique équipée de 2 humbuckers avec capot doré. 22 frettes."),
(6,2,"Jazz-typed guitar with tiger look. Semi acoustic equipped with 2 humbuckers and golden front. 22 frets."),

(7,1,"Inspired by the stylish lines and effortless performance of the Café Racer bikes that colored the streets of 1960 London."),
(7,2,"Inspirée par les lignes stylisées et les performances des cafés bikers qui ont coloré les rues de Londres en 1960"),
(8,1,"One of the best electric guitar values for over a decade, Yamaha Pacifica guitars are well known for great tone and outstanding playability."),
(8,2,"Une des meilleures guitares éléctriques depuis plus de 10 ans, Yamaha Pacifica sont des guitares bien connues pour un très bon son et une jouabilité hors du commun."),
(9,1,"Excellente guitare pour débutants et confirmés."),
(9,2,"Excellent guitar both for beginners and confirmed players."),
(10,1,"Intemporelle en temps et tradition. Nos artistes savent ce secret depuis des années"),
(10,2,"Boundless in time and tradition. Our artists have known this secret for years."),
(11,1,"Le design double cutaway, un manche rapide et un son très lourd produit par 2 humbuckers fait de la RGX220 un exemple parfait de l'accessibilité pour une guitare éléctrique moderne."),
(11,2,"The Double Cutaway Design, a fast neck and fat sounds from 2 Humbuckers make the RGX 220 a perfect example for a affordable modern electric guitar."),

(12,1,"Créée en 1976, la vénérable MockingBird a été classée comme la “guitare la plus cool de tous les temps” par le magazine Guitar World en 2010."),
(12,2,"Designed in ‘76, the venerable Mockingbird was ranked as the “coolest guitar of all time” by Guitar World Magazine in 2010."),
(13,1,"La BC Rich Pro X Custom est une édition limitée qui hérite fièrement de la célèbre forme de corps de la Mockingbird."),
(13,2,"The B.C. Rich Pro X Custom electric guitar is a special limited edition that bows to its rich heritage featuring the famous and iconic Mockingbird body style"),
(14,1,"Les guitares Warlock comprennent une disposition 3 pièces, un design neck-through, et un bois très solide."),
(14,2,"Warlock guitars feature three piece, solid neck through construction, solid wood."),
(15,1,"Un seul contrôle de volume avec trois possibilités de réglage."),
(15,2,"Single volume/tone controls with Three way switching."),
(16,1,"Un design unique qui rappelle tout le savoir-faire de Fender."),
(16,2,"A unique design that reminds of the knowledge provided by Fender"),
(17,1,"Arborée d'une finition Lilac, la FSR Classic est hauntée par les fantômes des années 60."),
(17,2,"Adorned with a classic Lilac finish, the Fender FSR Classic '60s Stratocaster is haunted by the ghost of the wild 60s. "),
(18,1,"L'incontournable de tous les fans de rock'n'roll des années 50."),
(18,2,"A must-have for any 50's rock'n'roll fan. "),
(19,1,"La Stratocaster Standard offre le son légendaire de la Fender avec une finition classique."),
(19,2,"The Standard Stratocaster offers the legendary Fender Sound with Classic styling."),
(20,1,"Les American Elite sont destinées aux guitaristes qui demandent toujours plus à leurs instruments. "),
(20,2,"There is a passion within players at every level that fuels a never-ending pursuit of creativity and expression. The Fender Elite Series was born out of that same passion."),
(21,1,"Expériences le look, la sensation et le son d'un instrument aussi unique que fiable."),
(21,2,"Experience the look, feel and tone of an instrument that's as unique as it is reliable."),
(22,1,"La Custom 22 est un cheval d'assaut avec toutes les sonorités que vous pourriez espérer de votre PRS."),
(22,2,"The Custom 22 is a classic workhorse with all the tones you’ve come to expect from your PRS."),
(23,1,"La Custom 24 est équipée avec le Floyd Rose original, testé par le temps."),
(23,2,"The Core “Floyd” Custom 24 is equipped with the time-tested Floyd Rose “Original” tremolo system."),
(24,1,"Cet instrument légendaire était le premier modèle que Paul Reed Smith a apporté au public du tout premier salon NAMM"),
(24,2,"This iconic instrument was the first model that Paul Reed Smith brought to the public at PRS Guitars’ first Winter NAMM"),
(25,1,"Le guitariste Mark Holcomb a pu trouver son son léthal avec la PRS à son nom, et ses Seymour Duncan alpha et omega."),
(25,2,"Guitarist Mark Holcomb helps achieve this full, lethal sound with his PRS guitars and signature Seymour Duncan Alpha and Omega pickups."),
(26,1,"La Singlecut offre un son acoustique brillant et une vaste variété de sons avec l'esthétique et le corps d'une single-cutaway."),
(26,2,"The Singlecut Hollowbody II offers brilliant acoustics and a vast array of tones with the sleek aesthetic of a single-cutaway body shape."),
(27,1,"La Zach Myers a assé de fonctionnalités pour satisfaire les musiciens les plus exigeants."),
(27,2,"The SE Zach Myers has enough features to satisfy even the most demanding musicians."),
(28,1,"Facile et abordable possibilité dans le monde des guitares 8 cordes !"),
(28,2,"Easy and affordable entry into the world of 8-String guitars !"),
(29,1,"Design solide et un son incroyable"),
(29,2,"Solid design and wonderful tone"),
(30,1,"La dernière version des Omen. Corps Maha avec manche rapide"),
(30,2,"Last version of Omen series. Maha body with fast neck."),
(31,1,"Guitare signature du guitariste principal d'Avenged Sevenfold"),
(31,2,"Signature guitar from Avenged Sevenfold's guitarist"),
(32,1,"Guitare équipée de mécaniques Tune-o-matic."),
(32,2,"Guitar equipped with Tune-o-matic mechanics."),
(33,1,"Guitare typée metal pour un son envoûtant et puissant."),
(33,2,"Metal-typed guitar for an immersive and powerful sound."),

(34,1,"Ibanez RG de la serie Gio avec un rapport qualité/prix imbattable"),
(34,2,"Ibanez Gio Series RG with unbeatable Price/Performance Ratio! "),
(35,1,"Un autre bon exemple que l'excellence peut être abordable."),
(35,2,"Another good example that excellence can be affordable."),
(36,1,"Modèle signature de Paul Stanley"),
(36,2,"Signature model from Paul Stanley"),
(37,1,"Corps typé mahogany en 3 pièces, manche en érable Wizard III profilé rosewood avec 24 frettes Jumbo"),
(37,2,"Mahogany body 3-piece maple neck Wizard III neck profile rosewood fretboard 24 jumbo frets"),
(38,1,"Modèle signature de Steve Vai"),
(38,2,"Steve Vai signature model"),
(39,1,"Une guitare n'a pas besoin de coûter une fortune pour sonner bien."),
(39,2,"A guitar doesn't have to cost a bundle to sound good. "),
(40,1,"La Les Paul Standard est le pilier de Gibson, et représente le parfait équilibre entre le design traditionnel et les fonctionnalités nouvelles."),
(40,2,"The Les Paul Standard is the flagship of Gibson's electric guitar collection and represents the perfect balance between traditional design and modern features. "),
(41,1,"Introduite en 1960 comme la successeuse de la légendaire Les Paul, la SG est vite devenue une alternative populaire pour beaucoup de musiciens rock."),
(41,2,"Originally introduced in the 60s as the successor to the legendary Les Paul, the SG quickly developed into a popular alternative for many rock musicians. "),
(42,1,"Guitare semi-acoustique équipée de deux pickups Gibson Burstbucker"),
(42,2,"Semi-Hollow guitar equipped with two Gibson Burstbucker pickups."),
(43,1,"Même les fabriquants traditionnels tels que Gibson veulent essayer quelque chose de nouveau, et donner à des modèles établis des nouvelles fonctionnalités flambant neuves à des guitares."),
(43,2,"Even a traditional manufacturer such as Gibson is willing to try something new, to give established models brand new features suitable for modern guitars."),
(44,1,"Grâce à une énorme livraison que nous avons reçu récemment, nous avons la possibilité d'offrir la Les Paul traditional à un prix incroyablement bas !"),
(44,2,"Due to a huge shipment we received recently, we are able to offer original Gibson USA Guitars at unbelievably low prices!"),
(45,1,"La Les Paul Deluxe a vu le jour pour la première fois en 1968 et est devenue le visage du rock classique des années 70. Excellent équilibre entre le vintage et le moderne"),
(45,2,"The Les Paul Deluxe first saw the light of day in 1968 and today is the face of 70s Classic Rock a great balance between vintage and modern. "),
(46,1,"Gibson présente une de ses meilleures offres actuelles, probablement la meilleure SG jamais faite"),
(46,2,"Gibson is presenting one its best offers yet, quite possibly the best value SG ever."),

(47,1,"Branchez, et amusez vous ! Le magnifique ukulélé Mino Aka (sourire en hawaïen)"),
(47,2,"Plug in and get happy! Fender's delightful concert ukulele, the Mino'Aka (Hawaiian for 'smile'),"),
(48,1,"Ukulélé de concert."),
(48,2,"Ukulele for the stage"),
(49,1,"Ukulélé avec un corps identique à une fender"),
(49,2,"Ukulele with a fender body style"),

(50,1,"La CD-60 acoustique offre un bon son et reste abordable pour les débutants"),
(50,2,"The CD-60 dreadnought acoustic model features a nice sounding guitar while being affordable for beginners"),
(51,1,"Unique dans son genre, l'excellence de Fender"),
(51,2,"A one-of-a-kind ! The excellence made in Fender"),
(52,1,"Paul Reed Smith lui-même a joué sur cette guitare à Woodstock II"),
(52,2,"Paul Reed Smith himself played this guitar at Woodstock II"),
(53,1,"Prix peu abordable, mais unique en son genre. Son métallique et puissant"),
(53,2,"Less abordable price, but this guitar is unique and has a metallic and powerful sound"),
(54,1,"Milieu de gamme efficace et de longue durée"),
(54,1,"Middle-end guitar with efficience against time"),
(55,1,"Manche en érable et frettes Jumbo"),
(55,2,"Features a maple neck and jumbo frets"),
(56,1,"La SA2200 a toujourd été le pinnacle de la perfection en matière de semi-acoustiques yamaha"),
(56,2,"The SA2200 has always been the pinnacle of perfection in Yamaha semi-hollow archtops."),
(57,1,"La Fender Nate Mendel Precision est une réplique de la Precision Bass de 1971 jouée par les Foo Fighter"),
(57,2,"The Fender Nate Mendel Precision Bass is a replica of the original ’71 Precision Bass played by the Foo Fighter"),
(58,1,"Actuellement en grande quantité en stock !"),
(58,2,"Right now available in stocks"),
(59,1,"Très peu d'exemplaires restants, dépêchez-vous !"),
(59,2,"Only a few ones left, hurry up !"),
(60,1,"Convient aux bassistes avancés"),
(60,2,"Complies for advanced bassists"),
(61,1,"Partageant le même design de corps que les séries AEL, son son lourd enchantera tous les bassistes"),
(61,2,"Sharing the same body style with the AEL series guitars, its fat tone will endear the AEB8E to any bass player. "),
(62,1,"Son acoustique unique, pas d'ampli nécessaire pour l'entraînement"),
(62,2,"Unique acoustic sound, no amp needed to practice"),
(63,1,"Avec son manche rapide, ses attaches pour sangle et ses mécaniques, le bassiste éléctrique se sentira comme à la maison"),
(63,2,"From its Jazz Bass guitar headstock, neck shape, strap button, and machine heads, it feels like home to the electric bassist"),
(64,1,"3 ans de garantie Rock N Shop, satisfait ou remboursé"),
(64,2,"3 Years RockNShop Warranty, money back guarantee");

insert into client (email,password,firstname,lastname,telephonenumber,mobilenumber,streetName,streetNumber,zipcode,city,idcountry) 

values 
("antoine@hotmail.com","68122c8038645ff477408a677245d23bc223f93c6bebf2e1b8f434a7e64ffffb","Antoine","Delarge",'08741125','0446597815',"Route de Paris","8","3480","Grenoble",1),
("bill@hotmail.com","4267a741ec83ff34697838074632e01604a65c7e280dbd04ad1e446c4298cfa0","Bill","Bumgardner",'088459635','0421478950',"Garden Street","10","1405A","New York",2),
("dinos@hotmail.com","a03f1423e47194ef34ab0426ce18e221a73195849e646f248138c17b5bdced26","Dinos","Costakis",'047588963','0478965289',"Kyoto Street","10","468A","Kyoto",3),
("hervé@hotmail.com","d3f084340a37d27dbb43d9acb512227276d909031538365e0726be8d191f486f","Hervé","Marquis",'08147593','0471589300',"Avenue Albert Premier","140","1070","Bruxelles",4),
("chad@hotmail.com","f9332c4861d85b57ea6ca32e3beb2e844deb48c4f5c7d665da4445cbc7ac789c","Chad","Bailey",'087599687','0498521780',"Rue des jardins","39","4500","Huy",4);
/*
Pour chacun des mots de passe, la construction en clair est : passwordprenom de l'utilisateur.
ex pour antoine, le mot de passe est : passwordantoine
*/

insert into promotion(idBrand,dateBeginning,dateEnd,percentageReduction)
values
(2,str_to_date('01,12,2016',"%d,%m,%Y"),str_to_date('07,12,2016',"%d,%m,%Y"),0.25),
(3,str_to_date('07,12,2016',"%d,%m,%Y"),str_to_date('14,01,2017',"%d,%m,%Y"),0.10),
(1,str_to_date('14,01,2017',"%d,%m,%Y"),str_to_date('21,01,2017',"%d,%m,%Y"),0.40),
(1,str_to_date('01,02,2017',"%d,%m,%Y"),str_to_date('19,03,2017',"%d,%m,%Y"),0.40),
(6,str_to_date('05,04,2017',"%d,%m,%Y"),str_to_date('13,06,2017',"%d,%m,%Y"),0.40),
(7,str_to_date('05,05,2017',"%d,%m,%Y"),str_to_date('21,05,2017',"%d,%m,%Y"),0.40),
(5,str_to_date('21,05,2017',"%d,%m,%Y"),str_to_date('28,05,2016',"%d,%m,%Y"),0.20);