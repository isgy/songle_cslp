package com.songle.sgl.songle

/**
 * Created by jing on 09/11/17.
 */
import android.content.Context
import android.location.Location
import java.io.File
import java.io.PrintStream
class UniversityMap(private val context: Context) {

        private val tag = "UniversityMap"

        val pointsOfInterest = listOf(PointOfInterest(
                id = 2,
                name = "Mary Br\u00fcck building",
                stub = "mary-bruck",
                area = "kb",
                type = "building",
                longitude = -3.1730116009930500,
                latitude = 55.9231925860886040,
                address1 = "Colin MacLaurin Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 4,
                name = "St Cecilia's Hall",
                stub = "st-cecilias-hall",
                area = "central",
                type = "building",
                longitude = -3.1864374876022340,
                latitude = 55.9488904424293240,
                address1 = "Niddry Street",
                address2 = "Cowgate",
                city = "Edinburgh",
                postcode = "EH1 1NQ"
        ), PointOfInterest(
                id = 9,
                name = "Edinburgh Centre for Carbon Innovation (ECCI)",
                stub = "ecci",
                area = "central",
                type = "building",
                longitude = -3.1840935499349143,
                latitude = 55.9486009337296800,
                address1 = "High School Yards",
                address2 = "Infirmary Street",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 10,
                name = "George Square (7)",
                stub = "7-george-sq",
                type = "building",
                longitude = -3.1887418181577230,
                latitude = 55.9444705808318500,
                address1 = "7 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ"
        ), PointOfInterest(
                id = 11,
                name = "Student Disability Service",
                stub = "disability-office",
                area = "central",
                type = "building",
                longitude = -3.1888836622238160,
                latitude = 55.9427473673666640,
                address1 = "Main University Library",
                address2 = "30 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LJ"
        ), PointOfInterest(
                id = 12,
                name = "Alison House",
                stub = "alison-house",
                area = "central",
                type = "building",
                longitude = -3.1864804029464720,
                latitude = 55.9461599733836400,
                address1 = "12 Nicolson Square",
                city = "Edinburgh",
                postcode = "EH8 9DF"
        ), PointOfInterest(
                id = 13,
                name = "Potterrow",
                stub = "potterrow",
                area = "central",
                type = "building",
                longitude = -3.1879234313964844,
                latitude = 55.9461719890707060,
                address1 = "5/2 Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 14,
                name = "Business School",
                stub = "business-school",
                area = "central",
                type = "building",
                longitude = -3.1873118877410890,
                latitude = 55.9431078681228900,
                address1 = "29 Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9JS"
        ), PointOfInterest(
                id = 15,
                name = "Bedlam Theatre",
                stub = "bedlam-theatre",
                area = "central",
                type = "building",
                longitude = -3.1908202171325684,
                latitude = 55.9463762551806900,
                address1 = "11b Bristo Place",
                city = "Edinburgh",
                postcode = "EH1 1EZ"
        ), PointOfInterest(
                id = 16,
                name = "Medical School (Old Medical School)",
                stub = "medical-school",
                area = "central",
                type = "building",
                longitude = -3.1905627250671387,
                latitude = 55.9452347542822000,
                address1 = "Teviot Place",
                city = "Edinburgh",
                postcode = "EH8 9AG"
        ), PointOfInterest(
                id = 17,
                name = "McEwan Hall",
                stub = "mcewan-hall",
                area = "central",
                type = "building",
                longitude = -3.1896400451660156,
                latitude = 55.9453789457260800,
                address1 = "Teviot Place",
                city = "Edinburgh",
                postcode = "EH8 9AG"
        ), PointOfInterest(
                id = 18,
                name = "Reid Concert Hall",
                stub = "reid-concert-hall",
                area = "central",
                type = "building",
                longitude = -3.1894040107727050,
                latitude = 55.9448983054919800,
                address1 = "Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 19,
                name = "Teviot Row House",
                stub = "teviot-row-house",
                area = "central",
                type = "building",
                longitude = -3.1889533996582030,
                latitude = 55.9449583858474800,
                address1 = "Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 20,
                name = "Hugh Robson Building",
                stub = "hugh-robson-building",
                area = "central",
                type = "building",
                longitude = -3.1899189949035645,
                latitude = 55.9442794724061900,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9XD"
        ), PointOfInterest(
                id = 21,
                name = "Edinburgh Global (formerly known as International Office)",
                stub = "edinburgh-global",
                area = "central",
                type = "building",
                longitude = -3.1854477524757385,
                latitude = 55.9431904824069100,
                address1 = "33 Buccluech Place",
                city = "Edinburgh",
                postcode = "EH8 9JS"
        ), PointOfInterest(
                id = 22,
                name = "Appleton Tower",
                stub = "appleton-tower",
                area = "central",
                type = "building",
                longitude = -3.1870651245117188,
                latitude = 55.9444416917442200,
                address1 = "11 Crichton Street",
                city = "Edinburgh",
                postcode = "EH8 9LE"
        ), PointOfInterest(
                id = 23,
                name = "College of Arts, Humanities and Social Sciences Office",
                stub = "college-of-arts-humanities-and-social-sciences-office",
                area = "central",
                type = "building",
                longitude = -3.1872582435607910,
                latitude = 55.9439970889746000,
                address1 = "55-56 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JU"
        ), PointOfInterest(
                id = 24,
                name = "George Square (50)",
                stub = "50-george-square",
                area = "central",
                type = "building",
                longitude = -3.1871938705444336,
                latitude = 55.9438408759789600,
                address1 = "50 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LH"
        ), PointOfInterest(
                id = 25,
                name = "David Hume Tower Lecture Theatres",
                stub = "david-hume-tower-lecture-theatres",
                area = "central",
                type = "building",
                longitude = -3.1862711906433105,
                latitude = 55.9435644975969700,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9LX"
        ), PointOfInterest(
                id = 26,
                name = "David Hume Tower",
                stub = "david-hume-tower",
                area = "central",
                type = "building",
                longitude = -3.1866574287414550,
                latitude = 55.9432040010911400,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9JX"
        ), PointOfInterest(
                id = 27,
                name = "Student Counselling Service",
                stub = "student-counselling-service",
                area = "central",
                type = "building",
                longitude = -3.1886690855026245,
                latitude = 55.9427804134090100,
                address1 = "Main University Library",
                address2 = "30 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LJ"
        ), PointOfInterest(
                id = 28,
                name = "Careers Service (Central Area)",
                stub = "careers-service",
                area = "central",
                type = "building",
                longitude = -3.1894576549530030,
                latitude = 55.9426602458471200,
                address1 = "Main University Library",
                address2 = "30 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LJ"
        ), PointOfInterest(
                id = 29,
                name = "Open Learning, Centre for",
                stub = "office-of-lifelong-learning",
                area = "central",
                type = "building",
                longitude = -3.1795978546142580,
                latitude = 55.9501339585784900,
                address1 = "Paterson's Land",
                address2 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 30,
                name = "International Students Centre",
                stub = "international-students-centre",
                area = "central",
                type = "building",
                longitude = -3.1877517700195312,
                latitude = 55.9424709811810700,
                address1 = "22b Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9LN"
        ), PointOfInterest(
                id = 31,
                name = "Main University Library",
                stub = "main-university-library",
                area = "central",
                type = "building",
                longitude = -3.1891465187072754,
                latitude = 55.9427113171064800,
                address1 = "30 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LJ"
        ), PointOfInterest(
                id = 32,
                name = "George Square Lecture Theatre",
                stub = "george-square-lecture-theatre",
                area = "central",
                type = "building",
                longitude = -3.1882023811340330,
                latitude = 55.9428795513669100,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9LH"
        ), PointOfInterest(
                id = 59,
                name = "Weir Building",
                stub = "weir-building",
                area = "kb",
                type = "building",
                longitude = -3.1792438030242920,
                latitude = 55.9231491035277340,
                address1 = "King's Buildings",
                address2 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 60,
                name = "Crew Building",
                stub = "crew-building",
                area = "kb",
                type = "building",
                longitude = -3.1776666641235350,
                latitude = 55.9230950007645600,
                address1 = "King's Buildings",
                address2 = "Alexander Crum Brown Road",
                city = "Edinburgh",
                postcode = "EH9 3FF"
        ), PointOfInterest(
                id = 61,
                name = "Joseph Black Building",
                stub = "joseph-black-building",
                area = "kb",
                type = "building",
                longitude = -3.1762075424194336,
                latitude = 55.9236600703440500,
                address1 = "David Brewster Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FJ"
        ), PointOfInterest(
                id = 62,
                name = "Roger Land Building",
                stub = "roger-land-building",
                area = "kb",
                type = "building",
                longitude = -3.1764221191406250,
                latitude = 55.9223014848946700,
                address1 = "Alexander Crum Brown Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FF"
        ), PointOfInterest(
                id = 63,
                name = "Peter Wilson Building",
                stub = "peter-wilson-building",
                area = "kb",
                type = "building",
                longitude = -3.1765186786651610,
                latitude = 55.9216221743117100,
                address1 = "Nicholas Kemmer Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FH"
        ), PointOfInterest(
                id = 64,
                name = "Grant Institute",
                stub = "grant-institute",
                area = "kb",
                type = "building",
                longitude = -3.1746411323547363,
                latitude = 55.9238464212712600,
                address1 = "James Hutton Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FE"
        ), PointOfInterest(
                id = 65,
                name = "King's Buildings House",
                stub = "kings-buildings-house",
                area = "kb",
                type = "building",
                longitude = -3.1748771667480470,
                latitude = 55.9235759115671200,
                address1 = "KB Square",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DL"
        ), PointOfInterest(
                id = 66,
                name = "King's Buildings Centre",
                stub = "kings-buildings-centre",
                area = "kb",
                type = "building",
                longitude = -3.1746411323547363,
                latitude = 55.9229447149150500,
                address1 = "Thomas Bayes Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FG"
        ), PointOfInterest(
                id = 67,
                name = "James Clerk Maxwell Building",
                stub = "james-clerk-maxwell-building",
                area = "kb",
                type = "building",
                longitude = -3.1740939617156982,
                latitude = 55.9216702674879260,
                address1 = "Peter Guthrie Tait Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FD"
        ), PointOfInterest(
                id = 68,
                name = "Ashworth Laboratories",
                stub = "ashworth-laboratories",
                area = "kb",
                type = "building",
                longitude = -3.1727099418640137,
                latitude = 55.9239606359128100,
                address1 = "Charlotte Auerbach Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FL"
        ), PointOfInterest(
                id = 69,
                name = "Sanderson Building",
                stub = "sanderson-building",
                area = "kb",
                type = "building",
                longitude = -3.1717228889465330,
                latitude = 55.9231010121864360,
                address1 = "Robert Stevenson Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FB"
        ), PointOfInterest(
                id = 70,
                name = "John Muir Building",
                stub = "john-muir-building",
                area = "kb",
                type = "building",
                longitude = -3.1732544302940370,
                latitude = 55.9227328108771200,
                address1 = "Colin Maclaurin Road ",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 71,
                name = "Hudson Beare Building",
                stub = "hudson-beare-building",
                area = "kb",
                type = "building",
                longitude = -3.1713366508483887,
                latitude = 55.9225239114362440,
                address1 = "Colin Maclaurin Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 72,
                name = "Alrick Building",
                stub = "alrick-building",
                area = "kb",
                type = "building",
                longitude = -3.1714224815368652,
                latitude = 55.9221632191038440,
                address1 = "Max Born Crescent",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 73,
                name = "Daniel Rutherford Building",
                stub = "daniel-rutherford-building",
                area = "kb",
                type = "building",
                longitude = -3.1706821918487550,
                latitude = 55.9219287672878450,
                address1 = "Max Born Crescent",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 74,
                name = "Darwin Building",
                stub = "darwin-building",
                area = "kb",
                type = "building",
                longitude = -3.1710684299468994,
                latitude = 55.9214177776469500,
                address1 = "Max Born Crescent",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 75,
                name = "Swann Building",
                stub = "michael-swann-building",
                area = "kb",
                type = "building",
                longitude = -3.1719267368316650,
                latitude = 55.9216101510083200,
                address1 = "Max Born Crescent",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 76,
                name = "John Murray Building",
                stub = "john-murray-labs",
                area = "kb",
                type = "building",
                longitude = -3.1734287738800050,
                latitude = 55.9234316389528840,
                address1 = "James Hutton Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FE"
        ), PointOfInterest(
                id = 77,
                name = "March Building",
                stub = "march-building",
                area = "kb",
                type = "building",
                longitude = -3.1728494167327880,
                latitude = 55.9234436616912500,
                address1 = "James Hutton Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FE"
        ), PointOfInterest(
                id = 78,
                name = "Ann Walker Building",
                stub = "ann-walker-building",
                area = "kb",
                type = "building",
                longitude = -3.1738901138305664,
                latitude = 55.9231070236073500,
                address1 = "Thomas Bayes Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FG"
        ), PointOfInterest(
                id = 79,
                name = "Structures Lab",
                stub = "structures-lab",
                area = "kb",
                type = "building",
                longitude = -3.1726777553558350,
                latitude = 55.9229086462244400,
                address1 = "Colin Maclaurin Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 80,
                name = "Fleeming Jenkin Building",
                stub = "fleeming-jenkin-building",
                area = "kb",
                type = "building",
                longitude = -3.1723880767822266,
                latitude = 55.9224096925608100,
                address1 = "Colin Maclaurin Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 81,
                name = "Alexander Graham Bell Building",
                stub = "alexander-graham-bell-building",
                area = "kb",
                type = "building",
                longitude = -3.1727340817451477,
                latitude = 55.9222684213808400,
                address1 = "King's Buildings",
                address2 = "Thomas Bayes Road",
                city = "Edinburgh",
                postcode = "EH9 3FG"
        ), PointOfInterest(
                id = 85,
                name = "Pleasance",
                stub = "pleasance",
                area = "central",
                type = "building",
                longitude = -3.1815088394796476,
                latitude = 55.9478375275095800,
                address1 = "Pleasance",
                city = "Edinburgh",
                postcode = "EH8 9TJ"
        ), PointOfInterest(
                id = 102,
                name = "Pollock Halls of Residence",
                stub = "pollock",
                type = "building",
                longitude = -3.1718409061431885,
                latitude = 55.9403791945471550,
                address1 = "18 Holyrood Park Road",
                city = "Edinburgh",
                postcode = "EH16 5AY"
        ), PointOfInterest(
                id = 104,
                name = "Abden House",
                stub = "abden-house",
                type = "building",
                longitude = -3.1692230701446533,
                latitude = 55.9374401075255800,
                address1 = "1 Marchhall Crescent",
                city = "Edinburgh",
                postcode = "EH16 5HP"
        ), PointOfInterest(
                id = 106,
                name = "South College Street",
                stub = "south-college-street",
                area = "central",
                type = "building",
                longitude = -3.1870731711387634,
                latitude = 55.9469785335416740,
                address2 = "South College Street",
                city = "Edinburgh",
                postcode = "EH8 9AA"
        ), PointOfInterest(
                id = 107,
                name = "George Square",
                stub = "george-square",
                area = "central",
                type = "building",
                longitude = -3.1886315345764160,
                latitude = 55.9435284480973960,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ"
        ), PointOfInterest(
                id = 108,
                name = "Informatics Forum",
                stub = "informatics-forum",
                area = "central",
                type = "building",
                longitude = -3.1875371932983400,
                latitude = 55.9446652929679200,
                address1 = "10 Crichton Street",
                city = "Edinburgh",
                postcode = "EH8 9AB"
        ), PointOfInterest(
                id = 109,
                name = "Dugald Stewart Building",
                stub = "dugald-stewart-building",
                area = "central",
                type = "building",
                longitude = -3.1880253553390503,
                latitude = 55.9454119895230000,
                address1 = "3 Charles Street",
                city = "Edinburgh",
                postcode = "EH8 9AD"
        ), PointOfInterest(
                id = 111,
                name = "Faraday Building",
                stub = "faraday-building",
                area = "kb",
                type = "building",
                longitude = -3.1716692447662354,
                latitude = 55.9223360512652800,
                address1 = "Colin Maclaurin Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DW"
        ), PointOfInterest(
                id = 112,
                name = "Chancellor's Building",
                stub = "chancellors-building",
                area = "littlefrance",
                type = "building",
                longitude = -3.1368756294250490,
                latitude = 55.9220181396980500,
                address1 = "49 Little France Crescent",
                city = "Edinburgh",
                postcode = "EH16 4SB"
        ), PointOfInterest(
                id = 113,
                name = "Queen's Medical Research Institute",
                stub = "qmri",
                area = "littlefrance",
                type = "building",
                longitude = -3.1388711929321290,
                latitude = 55.9222413693940400,
                address1 = "47 Little France Crescent",
                city = "Edinburgh",
                postcode = "EH16 4TJ"
        ), PointOfInterest(
                id = 114,
                name = "Chrystal Macmillan Building",
                stub = "chrystal-macmillan-building",
                area = "central",
                type = "building",
                longitude = -3.1908416748046875,
                latitude = 55.9441765328811300,
                address1 = "15a George Square",
                city = "Edinburgh",
                postcode = "EH8 9LD"
        ), PointOfInterest(
                id = 115,
                name = "Visitor Centre",
                stub = "visitor-centre",
                area = "central",
                type = "building",
                longitude = -3.1877946853637695,
                latitude = 55.9450867572402600,
                address1 = "2 Charles Street",
                city = "Edinburgh",
                postcode = "EH8 9AD"
        ), PointOfInterest(
                id = 116,
                name = "Talbot Rice Gallery",
                stub = "talbot-rice-gallery",
                area = "central",
                type = "building",
                longitude = -3.1878644227981567,
                latitude = 55.9471933088459540,
                address1 = "Old College",
                address2 = "South Bridge",
                city = "Edinburgh",
                postcode = "EH8 9YL"
        ), PointOfInterest(
                id = 117,
                name = "Charles Stewart House",
                stub = "charles-stewart-house",
                area = "central",
                type = "building",
                longitude = -3.1879770755767822,
                latitude = 55.9479614837865200,
                address1 = "9-16 Chambers Street",
                city = "Edinburgh",
                postcode = "EH1 1HR"
        ), PointOfInterest(
                id = 118,
                name = "Royal (Dick) School of Veterinary Studies",
                stub = "dick-vet-easter-bush",
                area = "easter",
                type = "building",
                longitude = -3.2010340690612793,
                latitude = 55.8658360390777300,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 119,
                name = "Buccleuch Place",
                stub = "buccleuch-place",
                area = "central",
                type = "building",
                longitude = -3.1865286827087402,
                latitude = 55.9428735430130360,
                address1 = "Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9JS"
        ), PointOfInterest(
                id = 120,
                name = "Erskine Williamson Building",
                stub = "erskine-williamson-building",
                area = "kb",
                type = "building",
                longitude = -3.1745553016662598,
                latitude = 55.9213997425953900,
                address1 = "Peter Guthrie Tait Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FD"
        ), PointOfInterest(
                id = 121,
                name = "Health Centre",
                stub = "health-centre",
                area = "central",
                type = "building",
                longitude = -3.1881996989250183,
                latitude = 55.9458580780220500,
                address1 = "6 Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 122,
                name = "William Rankine Building",
                stub = "william-rankine-building",
                area = "kb",
                type = "building",
                longitude = -3.1731122732162476,
                latitude = 55.9225299229466700,
                address1 = "Thomas Bayes Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FG"
        ), PointOfInterest(
                id = 126,
                name = "Charteris Land",
                stub = "charteris-land",
                area = "central",
                type = "building",
                longitude = -3.1809121370315550,
                latitude = 55.9501515797825100,
                address1 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 127,
                name = "Simon Laurie House",
                stub = "simon-laurie-house",
                area = "central",
                type = "building",
                longitude = -3.1815370917320250,
                latitude = 55.9509011741071300,
                address1 = "186 -198 Canongate",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 128,
                name = "St John's Land",
                stub = "st-johns-land",
                area = "central",
                type = "building",
                longitude = -3.1810247898101807,
                latitude = 55.9508486118686200,
                address1 = "Holyrood",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 129,
                name = "Dalhousie Land",
                stub = "dalhousie-land",
                area = "central",
                type = "building",
                longitude = -3.1807351112365723,
                latitude = 55.9506295517108000,
                address1 = "Holyrood",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 130,
                name = "Old Nursery School Building",
                stub = "nursery",
                area = "central",
                type = "building",
                longitude = -3.1806653738021850,
                latitude = 55.9504253080368300,
                address1 = "Holyrood",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 131,
                name = "Thomson's Land",
                stub = "thomsons-land",
                area = "central",
                type = "building",
                longitude = -3.1800457835197450,
                latitude = 55.9507765263969360,
                address1 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 132,
                name = "Moray House Reception / Old Moray House",
                stub = "moray-house-reception",
                area = "central",
                type = "building",
                longitude = -3.1804883480072020,
                latitude = 55.9510920995776900,
                address1 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 133,
                name = "Roslin Institute",
                stub = "roslin-institute",
                area = "easter",
                type = "building",
                longitude = -3.1981158256530760,
                latitude = 55.8654627786743400,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 134,
                name = "Procurement Office incorporating Printing Services",
                stub = "procurement-office",
                area = "central",
                type = "building",
                longitude = -3.1851929426193237,
                latitude = 55.9483617857850800,
                address1 = "13 Infirmary Street",
                city = "Edinburgh",
                postcode = "EH1 1LT"
        ), PointOfInterest(
                id = 135,
                name = "MacKenzie Medical Centre",
                stub = "mackenzie-medical-centre",
                area = "central",
                type = "building",
                longitude = -3.1835299730300903,
                latitude = 55.9455922279190640,
                address1 = "Levinson House",
                address2 = "20 West Richmond Street",
                city = "Edinburgh",
                postcode = "EH8 9DX"
        ), PointOfInterest(
                id = 136,
                name = "Roxburgh Street (1)",
                stub = "roxburgh-street",
                area = "central",
                type = "building",
                longitude = -3.1833046674728394,
                latitude = 55.9478807820734050,
                address1 = "1 Roxburgh Street",
                city = "Edinburgh",
                postcode = "EH8 9TA"
        ), PointOfInterest(
                id = 137,
                name = "Western General Hospital",
                stub = "western-general",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2348728179931640,
                latitude = 55.9620294457321560,
                address1 = "Crewe Road South",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 138,
                name = "Hope Park Square",
                stub = "hope-park",
                area = "central",
                type = "building",
                longitude = -3.1860485672950745,
                latitude = 55.9420752097637600,
                address1 = "Hope Park Square",
                city = "Edinburgh",
                postcode = "EH8 9NW"
        ), PointOfInterest(
                id = 139,
                name = "Careers Service (King's Buildings)",
                area = "kb",
                type = "building",
                longitude = -3.1792491674423218,
                latitude = 55.9232092176204700,
                address1 = "Weir Building",
                address2 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 140,
                name = "Peffermill Playing Fields",
                stub = "peffermill",
                type = "building",
                longitude = -3.1566488742828370,
                latitude = 55.9299714578133160,
                address1 = "Laurie Liddell Clubhouse",
                address2 = "42 Peffermill Road",
                city = "Edinburgh",
                postcode = "EH16 5LL"
        ), PointOfInterest(
                id = 141,
                name = "Firbush",
                stub = "firbush",
                type = "building",
                longitude = -4.2703503370285030,
                latitude = 56.4751287681757600,
                address1 = "Killin",
                address2 = "Perthshire",
                postcode = "FK21 8SU"
        ), PointOfInterest(
                id = 142,
                name = "Royal Observatory, Edinburgh",
                stub = "royal-observatory",
                type = "building",
                longitude = -3.1872367858886720,
                latitude = 55.9228601538269600,
                address1 = "Blackford Hill",
                city = "Edinburgh",
                postcode = "EH9 3HJ"
        ), PointOfInterest(
                id = 143,
                name = "Waddington Building",
                stub = "ch-waddington",
                area = "kb",
                type = "building",
                longitude = -3.1700813770294190,
                latitude = 55.9216402092597900,
                address1 = "Max Born Crescent",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 144,
                name = "Labyrinth",
                stub = "labyrinth",
                area = "central",
                type = "building",
                longitude = -3.1895273923873900,
                latitude = 55.9438284590276300,
                address1 = "George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ."
        ), PointOfInterest(
                id = 145,
                name = "Institute for Academic Development",
                stub = "academic-development",
                area = "central",
                type = "building",
                longitude = -3.1821757704892660,
                latitude = 55.9498129209811600,
                address1 = "1 Morgan Lane",
                city = "Edinburgh",
                postcode = "EH8 8FP"
        ), PointOfInterest(
                id = 146,
                name = "Royal Edinburgh Hospital",
                stub = "royal-edinburgh-hospital",
                type = "building",
                longitude = -3.2134473323822020,
                latitude = 55.9278273042274700,
                address1 = "Morningside Terrace",
                city = "Edinburgh",
                postcode = "EH10 5HF"
        ), PointOfInterest(
                id = 147,
                name = "Hospital for Small Animals",
                stub = "small-animals-hospital",
                area = "easter",
                type = "building",
                longitude = -3.2022893428802490,
                latitude = 55.8650834942677400,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 149,
                name = "Infirmary Street (9-11)",
                stub = "Infirmary Steet",
                area = "central",
                type = "building",
                longitude = -3.1853377819061280,
                latitude = 55.9483347520127000,
                address1 = "9-11 Infirmary Street",
                postcode = "EH1 1NP"
        ), PointOfInterest(
                id = 150,
                name = "Bristo Square (7)",
                stub = "bristo-square",
                area = "central",
                type = "building",
                longitude = -3.1881058216094970,
                latitude = 55.9456913586793300,
                address1 = "7 Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 151,
                name = "John McIntyre Conference Centre",
                stub = "john-mcIntyre-conference-centre",
                type = "building",
                longitude = -3.1700706481933594,
                latitude = 55.9400090542789300,
                address1 = "18 Holyrood Park Road",
                city = "Edinburgh",
                postcode = "EH16 5AY"
        ), PointOfInterest(
                id = 152,
                name = "Library Annexe",
                stub = "library-annexe",
                type = "building",
                longitude = -3.3035373687744140,
                latitude = 55.9305003655093700,
                address1 = "Unit 1a",
                address2 = "20-22 South Gyle Crescent",
                city = "Edinburgh",
                postcode = "EH12 9EB"
        ), PointOfInterest(
                id = 153,
                name = "Old Surgeons' Hall",
                stub = "old-surgeons-hall",
                area = "central",
                type = "building",
                longitude = -3.1831464171409607,
                latitude = 55.9484864412690800,
                address1 = "Surgeons Square",
                address2 = "High School Yards",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 154,
                name = "Old Infirmary (Geography)",
                stub = "institute-of-geography",
                area = "central",
                type = "building",
                longitude = -3.1837606430053710,
                latitude = 55.9482334252486500,
                address1 = "1 Drummond Street",
                city = "Edinburgh",
                postcode = "EH8 9XP"
        ), PointOfInterest(
                id = 155,
                name = "Drummond Library (GeoSciences)",
                stub = "drummond-library",
                area = "central",
                type = "building",
                longitude = -3.1829774379730225,
                latitude = 55.9486869905629200,
                address1 = "High School Yards",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 156,
                name = "Chisholm House",
                stub = "chisholm-house",
                area = "central",
                type = "building",
                longitude = -3.1830418109893800,
                latitude = 55.9488491914385600,
                address1 = "1 Surgeons Square",
                address2 = "High School Yards",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 157,
                name = "Drummond Street Annex",
                stub = "drummond-street-annex",
                area = "central",
                type = "building",
                longitude = -3.1829130649566650,
                latitude = 55.9482574553323400,
                address1 = "1 Drummond Street",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 158,
                name = "Evolution House",
                stub = "evolution-house",
                area = "central",
                type = "building",
                longitude = -3.2005995512008667,
                latitude = 55.9460736605762700,
                address1 = "78 Westport",
                city = "Edinburgh",
                postcode = "EH1 2LE"
        ), PointOfInterest(
                id = 159,
                name = "Hunter Building",
                stub = "hunter-building",
                area = "central",
                type = "building",
                longitude = -3.1980729103088380,
                latitude = 55.9451282124570850,
                address1 = "Lauriston Place",
                city = "Edinburgh",
                postcode = "EH3 9DF"
        ), PointOfInterest(
                id = 160,
                name = "ECA Main Building",
                stub = "eca-main-building",
                area = "central",
                type = "building",
                longitude = -3.1990599632263184,
                latitude = 55.9458551741833600,
                address1 = "Lauriston Place",
                city = "Edinburgh",
                postcode = "EH3 9DF"
        ), PointOfInterest(
                id = 162,
                name = "William Robertson Wing",
                stub = "william-robertson-wing",
                area = "central",
                type = "building",
                longitude = -3.1907665729522705,
                latitude = 55.9450080521798600,
                address1 = "Doorway 4",
                address2 = "Teviot Place",
                city = "Edinburgh",
                postcode = "EH8 9AG"
        ), PointOfInterest(
                id = 163,
                name = "Economics, School of",
                stub = "economics",
                area = "central",
                type = "building",
                longitude = -3.1860029697418213,
                latitude = 55.9431288972300800,
                address1 = "30-31 Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9JT"
        ), PointOfInterest(
                id = 164,
                name = "Scottish Centre for Regenerative Medicine",
                stub = "SCRM",
                area = "littlefrance",
                type = "building",
                longitude = -3.1307816505432130,
                latitude = 55.9213756958468900,
                address1 = "Edinburgh BioQuarter",
                address2 = "5 Little France Drive",
                city = "Edinburgh",
                postcode = "EH16 4UU"
        ), PointOfInterest(
                id = 165,
                name = "Edinburgh Imaging Facility (QMRI)",
                stub = "imaging-facility-QMRI",
                area = "littlefrance",
                type = "building",
                longitude = -3.1395041942596436,
                latitude = 55.9218746628211960,
                address1 = "47 Little France Crescent",
                city = "Edinburgh",
                postcode = "EH16 4TJ"
        ), PointOfInterest(
                id = 166,
                name = "Riddell-Swan Veterinary Cancer Centre",
                stub = "riddell-swan-building",
                area = "easter",
                type = "building",
                longitude = -3.2020211219787598,
                latitude = 55.8647884927243440,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 167,
                name = "Equine Hospital",
                stub = "equine-hospital",
                area = "easter",
                type = "building",
                longitude = -3.1992530822753906,
                latitude = 55.8642948116602700,
                address1 = "Easter Bush Campus",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 168,
                name = "Easter Bush Campus Service Centre",
                stub = "easter-campus-management",
                area = "easter",
                type = "building",
                longitude = -3.1989848613739014,
                latitude = 55.8665524481898640,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 169,
                name = "Sir Alexander Robertson Building",
                stub = "alexander-robertson",
                area = "easter",
                type = "building",
                longitude = -3.1983304023742676,
                latitude = 55.8648005336474900,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 170,
                name = "Farm Animal Practice and Equine Clinical Unit",
                stub = "farm-animal-practice",
                area = "easter",
                type = "building",
                longitude = -3.1991994380950928,
                latitude = 55.8648607382074200,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 171,
                name = "Farm Animal Hospital",
                stub = "farm-animal-unit",
                area = "easter",
                type = "building",
                longitude = -3.1998538970947266,
                latitude = 55.8641382773298200,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 172,
                name = "Scintigraphy and Exotic Animal Unit",
                stub = "scintigraphy-exotics",
                area = "easter",
                type = "building",
                longitude = -3.1989204883575440,
                latitude = 55.8637529593674600,
                address1 = "Easter Bush",
                city = "Midlothian",
                postcode = "EH25 9RG"
        ), PointOfInterest(
                id = 173,
                name = "Biomedical Research Facility",
                stub = "biomedical-research-facility",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2382416725158690,
                latitude = 55.9628822006132100,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 174,
                name = "CJD Surveillance Unit",
                stub = "cjd-surveillance-unit",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2370507717132570,
                latitude = 55.9621555585534200,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 175,
                name = "Wellcome Trust Clinical Research Facility",
                stub = "wellcome-trust-clinical-research",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2354736328125000,
                latitude = 55.9622036014248400,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 176,
                name = "Clinical Neurosciences",
                stub = "clinical-neurosciences",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2371473312377930,
                latitude = 55.9618192567835000,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 177,
                name = "Bramwell Dott Building",
                stub = "bramwell-dott-building",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2368093729019165,
                latitude = 55.9613568370782500,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 178,
                name = "Division of Pathology Laboratories",
                stub = "pathology-labs",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2339179515838623,
                latitude = 55.9620714833849000,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 179,
                name = "IGMM Complex",
                stub = "igmm-complex",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2323193550109863,
                latitude = 55.9622936816480400,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 180,
                name = "Noreen and Kenneth Murray Library",
                stub = "noreen-kenneth-murray-library",
                area = "kb",
                type = "building",
                longitude = -3.1750380992889404,
                latitude = 55.9229507263602100,
                address1 = "Thomas Bayes Road",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3FG"
        ), PointOfInterest(
                id = 181,
                name = "Anatomical Museum",
                stub = "anatomical-museum",
                area = "central",
                type = "building",
                longitude = -3.1900537014010410,
                latitude = 55.9450908404547600,

                address1 = "Doorway 3, Medical School",
                address2 = "Teviot Place",
                city = "Edinburgh",
                postcode = "EH8 9AG"
        ), PointOfInterest(
                id = 182,
                name = "Reid Museum of Musical Instruments",
                stub = "reid-museum",
                area = "central",
                type = "building",
                longitude = -3.1891578435900670,
                latitude = 55.9449286238358500,
                address1 = "Reid Concert Hall",
                address2 = "Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 221,
                name = "Student Recruitment and Admissions",
                stub = "student-recruitment-admissions",
                area = "central",
                type = "building",
                longitude = -3.1854933500289917,
                latitude = 55.9431919844831500,

                address1 = "33 Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9JT"
        ), PointOfInterest(
                id = 222,
                name = "George Square (16-22)",
                stub = "16-27-george-square",
                area = "central",
                type = "building",
                longitude = -3.1905305385589600,
                latitude = 55.9434923985642300,
                address1 = "16-22 George Square",
                city = "Edinbrugh",
                postcode = "EH8 9LD"
        ), PointOfInterest(
                id = 223,
                name = "George Square (2-15)",
                stub = "1-15-george-square",
                area = "central",
                type = "building",
                longitude = -3.1889963150024414,
                latitude = 55.9444476998548050,
                address1 = "2-15 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ"
        ), PointOfInterest(
                id = 224,
                name = "George Square (55-60)",
                stub = "55-60-george-square",
                area = "central",
                type = "building",
                longitude = -3.1872904300689697,
                latitude = 55.9441773339558350,
                address1 = "55-60 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JU"
        ), PointOfInterest(
                id = 225,
                name = "George Square (1)",
                stub = "1-george-square",
                area = "central",
                type = "building",
                longitude = -3.1880736351013184,
                latitude = 55.9445678618707000,
                address1 = "1 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ"
        ), PointOfInterest(
                id = 226,
                name = "FloWave Ocean Energy Research Facility",
                stub = "flowave",
                area = "kb",
                type = "building",
                longitude = -3.1787583231925964,
                latitude = 55.9221391728290200,

                address1 = "Building 29, King's Buildings",
                address2 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 228,
                name = "Edinburgh Dental Institute",
                stub = "dental",
                area = "central",
                type = "building",
                longitude = -3.1972124129561053,
                latitude = 55.9444931361609100,

                address1 = "4th Floor, Lauriston Building",
                address2 = "Lauriston Place",
                city = "Edinburgh",
                postcode = "EH3 9HA"
        ), PointOfInterest(
                id = 229,
                name = "Medical Education Centre",
                stub = "medical-education-centre",
                area = "westerngeneral",
                type = "building",
                longitude = -3.2344329357147217,
                latitude = 55.9623867643250750,
                address1 = "Western General Hospital",
                city = "Edinburgh",
                postcode = "EH4 2XU"
        ), PointOfInterest(
                id = 235,
                name = "Arcadia Nursery",
                stub = "arcadia",
                area = "kb",
                type = "building",
                longitude = -3.1770189106464386,
                latitude = 55.9243168030941800,
                address1 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 236,
                name = "Christina Miller Building",
                stub = "christina-miller",
                area = "kb",
                type = "building",
                longitude = -3.1762893497943880,
                latitude = 55.9228830975483100,
                address1 = "KB Square",
                address2 = "King's Buildings",
                city = "Edinburgh",
                postcode = "EH9 3DL"
        ), PointOfInterest(
                id = 238,
                name = "St Leonard's Land",
                stub = "st-leonards-land",
                area = "central",
                type = "building",
                longitude = -3.1796447932720184,
                latitude = 55.9494235973597600,
                address1 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 242,
                name = "Forrest Hill Building",
                stub = "forrest-hill-building",
                area = "central",
                type = "building",
                longitude = -3.1919199228286743,
                latitude = 55.9460157848478160,
                address1 = "5 Forrest Hill",
                city = "Edinburgh",
                postcode = "EH1 2QL"
        ), PointOfInterest(
                id = 243,
                name = "Sport and Exercise",
                stub = "centre-sport-exercise",
                area = "central",
                type = "building",
                longitude = -3.1814534553996054,
                latitude = 55.9482471864297600,
                address1 = "46 Pleasance",
                city = "Edinburgh",
                postcode = "EH8 9TJ"
        ), PointOfInterest(
                id = 245,
                name = "High School Yards",
                stub = "high-school-yards",
                area = "central",
                type = "building",
                longitude = -3.1839591264724730,
                latitude = 55.9486696690834200,
                address1 = "High School Yards",
                city = "Edinburgh",
                postcode = "EH1 1LZ"
        ), PointOfInterest(
                id = 246,
                name = "North-East Studio Building",
                stub = "north-east-studio",
                area = "central",
                type = "building",
                longitude = -3.1977570356684737,
                latitude = 55.9459624149394800,
                address1 = "Lauriston Place",
                city = "Edinburgh",
                postcode = "EH3 9DF"
        ), PointOfInterest(
                id = 247,
                name = "Paterson's Land",
                stub = "patersons-land",
                area = "central",
                type = "building",
                longitude = -3.1797011196613310,
                latitude = 55.9500919079601800,
                address1 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 265,
                name = "Wilkie Building",
                stub = "wilkie",
                area = "central",
                type = "building",
                longitude = -3.1891815438893900,
                latitude = 55.9447400183455340,
                address1 = "Medical School",
                address2 = "22 - 23 Teviot Row",
                city = "Edinburgh",
                postcode = "EH8 9AG"
        ), PointOfInterest(
                id = 267,
                name = "George Square (27-29)",
                stub = "27-29-george-sq",
                area = "central",
                type = "building",
                longitude = -3.1902951300253335,
                latitude = 55.9430755233431750,
                address1 = "27-29 George Square",
                city = "Edinburgh",
                postcode = "EH8 9LD"
        ), PointOfInterest(
                id = 268,
                name = "Buccleuch Place (17-25)",
                stub = "17-25-buccleuch",
                area = "central",
                type = "building",
                longitude = -3.1878757776576094,
                latitude = 55.9424656737581000,
                address1 = "17-25 Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9LN"
        ), PointOfInterest(
                id = 269,
                name = "Buccleuch Place (14-16)",
                stub = "14-16-buccleuch",
                area = "central",
                type = "building",
                longitude = -3.1867445111493000,
                latitude = 55.9426225932921140,
                address1 = "14-16 Buccleuch Place",
                city = "Edinburgh",
                postcode = "EH8 9LN"
        ), PointOfInterest(
                id = 270,
                name = "Chaplaincy",
                stub = "chaplaincy",
                area = "central",
                type = "building",
                longitude = -3.1882885248342063,
                latitude = 55.9462294139965200,
                address1 = "1 Bristo Square",
                city = "Edinburgh",
                postcode = "EH8 9AL"
        ), PointOfInterest(
                id = 273,
                name = "Old Kirk",
                stub = "old-kirk",
                area = "central",
                type = "building",
                longitude = -3.1805157959570350,
                latitude = 55.9497682168029700,
                address1 = "37 Holyrood Rd",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 274,
                name = "Outreach Centre",
                stub = "outreach",
                area = "central",
                type = "building",
                longitude = -3.1815886795629920,
                latitude = 55.9495279246704600,
                address1 = "9C Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8FP"
        ), PointOfInterest(
                id = 276,
                name = "Biospace",
                stub = "biospace",
                area = "kb",
                type = "building",
                longitude = -3.1787515282849200,
                latitude = 55.9224952565814800,
                address1 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 277,
                name = "UK Biochar Research Centre",
                stub = "biochar-research",
                area = "kb",
                type = "building",
                longitude = -3.1784296632031330,
                latitude = 55.9231865746809500,
                address1 = "Max Born Crescent",
                city = "Edinburgh",
                postcode = "EH9 3BF"
        ), PointOfInterest(
                id = 278,
                name = "Anne Rowling Regenerative Neurology Clinic",
                stub = "regenerative-neurology",
                area = "littlefrance",
                type = "building",
                longitude = -3.1377825290019246,
                latitude = 55.9218908679254340,
                address1 = "49 Little France Crescent",
                city = "Edinburgh",
                postcode = "EH16 4SB"
        ), PointOfInterest(
                id = 279,
                name = "Minto House",
                stub = "minto-house",
                area = "central",
                type = "building",
                longitude = -3.1890824587026145,
                latitude = 55.9477839098566900,
                address1 = "20-22 Chambers Street",
                city = "Edinburgh",
                postcode = "EH1 1HT"
        ), PointOfInterest(
                id = 281,
                name = "Old College",
                stub = "old-college",
                area = "central",
                type = "building",
                longitude = -3.1864655617391690,
                latitude = 55.9475371471338900,
                address1 = "South Bridge",
                city = "Edinburgh",
                postcode = "EH8 9YL"
        ), PointOfInterest(
                id = 282,
                name = "Institute for Advanced Studies in the Humanities",
                stub = "iash",
                area = "central",
                type = "building",
                longitude = -3.1859871894175740,
                latitude = 55.9421498800494850,
                address1 = "Hope Park Square",
                city = "Edinburgh",
                postcode = "EH8 9NW"
        ), PointOfInterest(
                id = 284,
                name = "Scottish Microelectronic Centre",
                stub = "scottish-micro-electronic-centre",
                area = "kb",
                type = "building",
                longitude = -3.1778985858181840,
                latitude = 55.9221375697679600,
                address1 = "Alexander Crum Brown Road",
                city = "Edinburgh",
                postcode = "EH9 3FF"
        ), PointOfInterest(
                id = 285,
                name = "Argyle House",
                stub = "argyle",
                area = "central",
                type = "building",
                longitude = -3.2010186018305830,
                latitude = 55.9465782172433200,
                address1 = "3 Lady Lawson Street",
                city = "Edinburgh",
                postcode = "EH3 9DR"
        ), PointOfInterest(
                id = 287,
                name = "Psychology Building",
                stub = "psychology-building",
                area = "central",
                type = "building",
                longitude = -3.1886053385096600,
                latitude = 55.9444754372987800,
                address1 = "7 George Square",
                city = "Edinburgh",
                postcode = "EH8 9JZ"
        ), PointOfInterest(
                id = 298,
                name = "New College",
                stub = "new-college",
                area = "central",
                type = "building",
                longitude = -3.1952270865440370,
                latitude = 55.9497044393992840,
                address1 = "Mound Place",
                city = "Edinburgh",
                postcode = "EH1 2LX"
        ), PointOfInterest(
                id = 299,
                name = "Edinburgh BioQuarter (9) - Usher Institute",
                stub = "nine-bioquarter",
                area = "littlefrance",
                type = "building",
                longitude = -3.1296175718307495,
                latitude = 55.9196563146633640,
                address1 = "9 Little France Road",
                city = "Edinburgh",
                postcode = "EH16 4UX"
        ), PointOfInterest(
                id = 303,
                name = "Edinburgh Centre for Professional Legal Studies",
                stub = "ecpls",
                area = "central",
                type = "building",
                longitude = -3.1818227469921110,
                latitude = 55.9495084509180400,
                address1 = "9B Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8FP"
        ), PointOfInterest(
                id = 305,
                name = "Edinburgh Imaging Facility RIE",
                stub = "imaging-facility-RIE",
                area = "littlefrance",
                type = "building",
                longitude = -3.1362640857696533,
                latitude = 55.9210540691517300,
                address1 = "57 Little France Crescent",
                city = "Edinburgh",
                postcode = "EH16 4TJ"
        ), PointOfInterest(
                id = 306,
                name = "Adam House",
                stub = "adam-house",
                area = "central",
                type = "building",
                longitude = -3.1873333454132080,
                latitude = 55.9480794321204600,
                address1 = "3 Chambers Street",
                city = "Edinburgh",
                postcode = "EH1 1HR"
        ), PointOfInterest(
                id = 307,
                name = "Edinburgh BioQuarter (9A) - Centre for Dementia Prevention",
                stub = "nine-a-bioquarter",
                area = "littlefrance",
                type = "building",
                longitude = -3.1286332011222840,
                latitude = 55.9202845589381400,
                address1 = "9a Little France Road",
                city = "Edinburgh",
                postcode = "EH16 4UX"
        ), PointOfInterest(
                id = 308,
                name = "Lister Learning And Teaching Centre",
                stub = "lister-learning-and-teaching-centre",
                area = "central",
                type = "building",
                longitude = -3.1840020418167114,
                latitude = 55.9468989312032360,
                address1 = "5 Roxburgh Place",
                city = "Edinburgh",
                postcode = "EH8 9SU"
        ), PointOfInterest(
                id = 309,
                name = "Lauriston Fire Station",
                stub = "lauriston-fire-station",
                area = "central",
                type = "building",
                longitude = -3.1988427042961120,
                latitude = 55.9452227383043100,
                address1 = "78 Lauriston Place",
                city = "Edinburgh",
                postcode = "EH3 9DE"
        ), PointOfInterest(
                id = 310,
                name = "Moray House Lodge",
                stub = "moray-house-lodge",
                area = "central",
                type = "building",
                longitude = -3.1789822876453400,
                latitude = 55.9501069260433700,
                address1 = "Moray House Lodge",
                address2 = "Holyrood Road",
                city = "Edinburgh",
                postcode = "EH8 8AQ"
        ), PointOfInterest(
                id = 209,
                name = "Mayfield, after Rankin Drive",
                area = "kb",
                type = "buspub",
                longitude = -3.1725382804870605,
                latitude = 55.9247781624674100
        ), PointOfInterest(
                id = 210,
                name = "Mayfield, before Rankin Drive",
                area = "kb",
                type = "buspub",
                longitude = -3.1726455688476562,
                latitude = 55.9246789781796000
        ), PointOfInterest(
                id = 211,
                name = "Mayfield, after Mayfield Road",
                area = "kb",
                type = "buspub",
                longitude = -3.1740376353263855,
                latitude = 55.9243829265988400
        ), PointOfInterest(
                id = 212,
                name = "Mayfield, before Observatory Road",
                area = "kb",
                type = "buspub",
                longitude = -3.1798875331878660,
                latitude = 55.9245843020317250
        ), PointOfInterest(
                id = 214,
                name = "Newington, at Kings Hall",
                type = "buspub",
                longitude = -3.1806921958923340,
                latitude = 55.9406984576726500
        ), PointOfInterest(
                id = 215,
                name = "South Side, opp Meadow Lane",
                type = "buspub",
                longitude = -3.1845009326934814,
                latitude = 55.9431679512560000
        ), PointOfInterest(
                id = 216,
                name = "South Side, before Marshall Street",
                type = "buspub",
                longitude = -3.1853377819061280,
                latitude = 55.9458475642108300
        ), PointOfInterest(
                id = 217,
                name = "South Side, Potterow (NW-bound)",
                type = "buspub",
                longitude = -3.1861424446105957,
                latitude = 55.9444176592925600
        ), PointOfInterest(
                id = 218,
                name = "South Side, Potterrow (SE-bound)",
                type = "buspub",
                longitude = -3.1867969036102295,
                latitude = 55.9456072477475400
        ), PointOfInterest(
                id = 220,
                name = "Canongate, after Gullan's Close",
                type = "buspub",
                longitude = -3.1811615824699400,
                latitude = 55.9494806670300300
        ), PointOfInterest(
                id = 203,
                area = "kb",
                type = "busshut",
                longitude = -3.1775164604187010,
                latitude = 55.9222594040540400
        ), PointOfInterest(
                id = 204,
                type = "busshut",
                longitude = -3.1870597600936890,
                latitude = 55.9458145207855700
        ), PointOfInterest(
                id = 82,
                type = "cafe",
                longitude = -3.1762517094830400,
                latitude = 55.9222427721145700
        ), PointOfInterest(
                id = 190,
                area = "kb",
                type = "cafe",
                longitude = -3.1720983982086180,
                latitude = 55.9215921160462400
        ), PointOfInterest(
                id = 191,
                area = "kb",
                type = "cafe",
                longitude = -3.1745982170104980,
                latitude = 55.9216762791307640
        ), PointOfInterest(
                id = 192,
                name = "Cafeterias",
                area = "kb",
                type = "cafe",
                longitude = -3.1749308109283447,
                latitude = 55.9229387034689500
        ), PointOfInterest(
                id = 193,
                name = "King's House Building",
                area = "kb",
                type = "cafe",
                longitude = -3.1749415397644043,
                latitude = 55.9235518661687000
        ), PointOfInterest(
                id = 195,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1892108917236330,
                latitude = 55.9427834175932800
        ), PointOfInterest(
                id = 196,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1864213943481445,
                latitude = 55.9436486129654800
        ), PointOfInterest(
                id = 197,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1952190399169920,
                latitude = 55.9493800441337540
        ), PointOfInterest(
                id = 198,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1816363334655760,
                latitude = 55.9476979510270500
        ), PointOfInterest(
                id = 200,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1886315345764160,
                latitude = 55.9450184661097500
        ), PointOfInterest(
                id = 201,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1881594657897950,
                latitude = 55.9462320674501900
        ), PointOfInterest(
                id = 202,
                name = "Cafeterias",
                area = "central",
                type = "cafe",
                longitude = -3.1869363784790040,
                latitude = 55.9429636682230500
        ), PointOfInterest(
                id = 248,
                type = "cafe",
                longitude = -3.1729686856488115,
                latitude = 55.9231685404523900
        ), PointOfInterest(
                id = 249,
                type = "cafe",
                longitude = -3.1762517094830400,
                latitude = 55.9222427721145700
        ), PointOfInterest(
                id = 250,
                type = "cafe",
                longitude = -3.1714344620922930,
                latitude = 55.9224591874726100
        ), PointOfInterest(
                id = 288,
                type = "cafe",
                longitude = -3.1837137043476105,
                latitude = 55.9486711709471700
        ), PointOfInterest(
                id = 110,
                name = "Information",
                area = "central",
                type = "info",
                longitude = -3.1877517700195312,
                latitude = 55.9449283456813800
        ), PointOfInterest(
                id = 184,
                name = "Moray House Library",
                area = "central",
                type = "lib",
                longitude = -3.1807780265808105,
                latitude = 55.9506025195216950
        ), PointOfInterest(
                id = 185,
                name = "Library Annexe",
                type = "lib",
                longitude = -3.3034408092498780,
                latitude = 55.9304943552351800
        ), PointOfInterest(
                id = 186,
                name = "New College Library",
                area = "central",
                type = "lib",
                longitude = -3.1952404975891113,
                latitude = 55.9495242201428600
        ), PointOfInterest(
                id = 187,
                name = "Main Library",
                area = "central",
                type = "lib",
                longitude = -3.1888461112976074,
                latitude = 55.9426872835810500
        ), PointOfInterest(
                id = 188,
                name = "Noreen and Kenneth Murray Library",
                area = "kb",
                type = "lib",
                longitude = -3.1750273704528810,
                latitude = 55.9228966233201300
        ), PointOfInterest(
                id = 230,
                area = "westerngeneral",
                type = "lib",
                longitude = -3.2351732254028320,
                latitude = 55.9615092792800440
        ), PointOfInterest(
                id = 231,
                area = "littlefrance",
                type = "lib",
                longitude = -3.1371599435806274,
                latitude = 55.9220994567561860
        ), PointOfInterest(
                id = 232,
                area = "easter",
                type = "lib",
                longitude = -3.2009696960449220,
                latitude = 55.8659383840456200
        ), PointOfInterest(
                id = 233,
                name = "Edinburgh College of Art Library",
                area = "central",
                type = "lib",
                longitude = -3.2006961107254030,
                latitude = 55.9461449537695200
        ), PointOfInterest(
                id = 304,
                name = "Law Library",
                type = "lib",
                longitude = -3.1865454465150833,
                latitude = 55.9431957396735560
        ), PointOfInterest(
                id = 1,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1370741128921510,
                latitude = 55.9225900379997900
        ), PointOfInterest(
                id = 6,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.2016408741583290,
                latitude = 55.8647711337324200
        ), PointOfInterest(
                id = 33,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1814968585968018,
                latitude = 55.9476258596895300
        ), PointOfInterest(
                id = 34,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1815397739410400,
                latitude = 55.9480403830473400
        ), PointOfInterest(
                id = 35,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1809175014495850,
                latitude = 55.9484248645138750
        ), PointOfInterest(
                id = 36,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1834065914154053,
                latitude = 55.9481365037718850
        ), PointOfInterest(
                id = 39,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1856220960617065,
                latitude = 55.9486141000838100
        ), PointOfInterest(
                id = 43,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1892538070678710,
                latitude = 55.9482094891115300
        ), PointOfInterest(
                id = 44,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1876552104949950,
                latitude = 55.9459797376299760
        ), PointOfInterest(
                id = 49,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1858581304550170,
                latitude = 55.9439670480628800
        ), PointOfInterest(
                id = 50,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1886422634124756,
                latitude = 55.9423748463933140
        ), PointOfInterest(
                id = 51,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1880803406238556,
                latitude = 55.9426609122536000
        ), PointOfInterest(
                id = 52,
                name = "Parking",
                area = "central",
                type = "parkperm",
                longitude = -3.1877651810646057,
                latitude = 55.9422591839105650
        ), PointOfInterest(
                id = 83,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1778919696807860,
                latitude = 55.9239906923415000
        ), PointOfInterest(
                id = 84,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1775888800621033,
                latitude = 55.9235067810065000
        ), PointOfInterest(
                id = 86,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1792008876800537,
                latitude = 55.9222834502542550
        ), PointOfInterest(
                id = 87,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1783533096313477,
                latitude = 55.9216822907726600
        ), PointOfInterest(
                id = 88,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1754243373870850,
                latitude = 55.9233835479621400
        ), PointOfInterest(
                id = 90,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1752204895019530,
                latitude = 55.9221271496860060
        ), PointOfInterest(
                id = 92,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1744909286499023,
                latitude = 55.9242070979398600
        ), PointOfInterest(
                id = 93,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1734126806259155,
                latitude = 55.9223976695017100
        ), PointOfInterest(
                id = 94,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1730532646179200,
                latitude = 55.9240688389469500
        ), PointOfInterest(
                id = 95,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1722700595855713,
                latitude = 55.9238464212712600
        ), PointOfInterest(
                id = 96,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1713151931762695,
                latitude = 55.9230228636295200
        ), PointOfInterest(
                id = 97,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1722700595855713,
                latitude = 55.9226621759403700
        ), PointOfInterest(
                id = 98,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1717818975448610,
                latitude = 55.9213020525868460
        ), PointOfInterest(
                id = 100,
                name = "KB Parking",
                area = "kb",
                type = "parkperm",
                longitude = -3.1705856323242188,
                latitude = 55.9215620577575000
        ), PointOfInterest(
                id = 219,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.1978822946985020,
                latitude = 55.8660555787854400
        ), PointOfInterest(
                id = 251,
                name = "KB Parking",
                type = "parkperm",
                longitude = -3.1742025017956620,
                latitude = 55.9227236934914600
        ), PointOfInterest(
                id = 252,
                name = "KB Parking",
                type = "parkperm",
                longitude = -3.1717342436422770,
                latitude = 55.9233361582522050
        ), PointOfInterest(
                id = 253,
                name = "KB Parking",
                type = "parkperm",
                longitude = -3.1727052033056680,
                latitude = 55.9236487490076540
        ), PointOfInterest(
                id = 260,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.2006288773845880,
                latitude = 55.8668261652064100
        ), PointOfInterest(
                id = 261,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.1978822946985020,
                latitude = 55.8660555787854400
        ), PointOfInterest(
                id = 262,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.2033420205334550,
                latitude = 55.8643564218187340
        ), PointOfInterest(
                id = 263,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.2016408741583290,
                latitude = 55.8647711337324200
        ), PointOfInterest(
                id = 264,
                name = "Easter Bush parking",
                type = "parkperm",
                longitude = -3.2017481625189250,
                latitude = 55.8652286812019340
        ), PointOfInterest(
                id = 289,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1802764534950256,
                latitude = 55.9506706848521800
        ), PointOfInterest(
                id = 290,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1792813539505005,
                latitude = 55.9491637791135400
        ), PointOfInterest(
                id = 291,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1991833448410034,
                latitude = 55.9454630571537400
        ), PointOfInterest(
                id = 292,
                name = "Parking",
                type = "parkperm",
                longitude = -3.2000496983528137,
                latitude = 55.9460659121459260
        ), PointOfInterest(
                id = 293,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1980568170547485,
                latitude = 55.9450244741308540
        ), PointOfInterest(
                id = 294,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1972762942314150,
                latitude = 55.9460149337377300
        ), PointOfInterest(
                id = 295,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1403249502182007,
                latitude = 55.9214478360476300
        ), PointOfInterest(
                id = 296,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1370741128921510,
                latitude = 55.9225900379997900
        ), PointOfInterest(
                id = 297,
                name = "Parking",
                type = "parkperm",
                longitude = -3.1370741128921510,
                latitude = 55.9225900379997900
        ), PointOfInterest(
                id = 300,
                type = "parkperm",
                longitude = -3.1876860558986664,
                latitude = 55.9427338485230340
        ), PointOfInterest(
                id = 301,
                type = "parkperm",
                longitude = -3.1902489066123962,
                latitude = 55.9433151545382540
        ), PointOfInterest(
                id = 302,
                type = "parkperm",
                longitude = -3.1858219206333160,
                latitude = 55.9482512722821800
        ), PointOfInterest(
                id = 3,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1331968903759844,
                latitude = 55.9223389568673200
        ), PointOfInterest(
                id = 54,
                name = "Parking",
                area = "central",
                type = "parkpub",
                longitude = -3.1885671615600586,
                latitude = 55.9476919434207200
        ), PointOfInterest(
                id = 254,
                name = "Western General Hospital parking",
                type = "parkpub",
                longitude = -3.2334591157268733,
                latitude = 55.9638458310991100
        ), PointOfInterest(
                id = 255,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1413413293194026,
                latitude = 55.9211260096090200
        ), PointOfInterest(
                id = 256,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1371141672570957,
                latitude = 55.9234344443077600
        ), PointOfInterest(
                id = 257,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1331968903759844,
                latitude = 55.9223389568673200
        ), PointOfInterest(
                id = 258,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1334972977856523,
                latitude = 55.9211246068480750
        ), PointOfInterest(
                id = 259,
                name = "Little France parking",
                type = "parkpub",
                longitude = -3.1315137148340000,
                latitude = 55.9188775582341100
        ), PointOfInterest(
                id = 55,
                name = "Teviot Row House",
                area = "central",
                type = "union",
                longitude = -3.1886208057403564,
                latitude = 55.9449944340160300
        ), PointOfInterest(
                id = 56,
                name = "The Potterow",
                area = "central",
                type = "union",
                longitude = -3.1882989406585693,
                latitude = 55.9460097769805000
        ), PointOfInterest(
                id = 57,
                name = "Pleasance",
                area = "central",
                type = "union",
                longitude = -3.1815505027770996,
                latitude = 55.9477400042452760
        ), PointOfInterest(
                id = 101,
                name = "King's House Building",
                area = "kb",
                type = "union",
                longitude = -3.1749415397644043,
                latitude = 55.9235699002189000
        ))

        fun nearestPOI(longitude: Double, latitude: Double): PointOfInterest {
            var currentMin = 1000000F
            var currentResult = pointsOfInterest[0]
            val results = FloatArray(10)
            pointsOfInterest.forEach { poi ->
                Location.distanceBetween(latitude, longitude, poi.latitude, poi.longitude, results)
                if (results[0] < currentMin) {
                    currentResult = poi
                    currentResult.distanceInMetres = results[0]
                    currentMin = results[0]
                }
            }
            return currentResult
        }

        fun nearestMarker(oldlg: Double, oldlat: Double, newlg: Double, newlat: Double){
                
        }

        val descriptionDict = mapOf(
                "building" to "University building",
                "union" to "Student union building",
                "parkpub" to "Public parking",
                "parkperm" to "Parking with permit only",
                "lib" to "Library",
                "cafe" to "Cafe",
                "busshut" to "Shuttle bus stop",
                "buspub" to "Public bus stop"
        )

        private fun toPlacemark(p: PointOfInterest) =
                Placemark(name = p.name, description = descriptionDict[p.type] ?: "",
                        style = p.type, longitude = p.longitude, latitude = p.latitude)

        // Be careful not to use forEach here, we want to have a list as the result
        private val placemarks = pointsOfInterest.map { p -> toPlacemark(p) }

        // Be careful not to use forEach here, we want to have a list as the result
        private val kmlPlacemarks = placemarks.map { p -> p.asKml() }

        private val styleDict = mapOf(
                "building" to "orange-circle",
                "union" to "red-diamond",
                "parkpub" to "ltblu-circle",
                "parkperm" to "ylw-stars",
                "lib" to "wht-circle",
                "cafe" to "blu-square",
                "busshut" to "grn-square",
                "buspub" to "orange-diamond"
        )

        // Find all the distinct types of Points of Interest
        private val distinctStyles = pointsOfInterest.map { p -> p.type }.distinct()

        // Have a red circle as the default style if we cannot fine a particular style in the map.
        private val styles = distinctStyles.map { p -> Style(id = p, scale = 1.75, icon = styleDict[p] ?: "red-circle") }
        private val kmlStyles = styles.map { s -> s.asKml() }

        fun writeToFile(filename: String) {
            println(">>>>>> [$tag] in writeToFile")
            val path = context.filesDir
            val file = File(path, filename)
            println(">>>>>> [$tag] in writeToFile, writing to file $file")
            PrintStream(file).use {
                it.println("""<?xml version="1.0" encoding="UTF-8"?>
                <kml xmlns="http://www.opengis.net/kml/2.2">
                <Document>
            """)
                kmlStyles.forEach { p -> it.println(p) }
                kmlPlacemarks.forEach { p -> it.println(p) }
                it.println("""
                </Document>
                </kml>
            """)
            }
        }

    }
