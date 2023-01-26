package com.salle.utilities;

import com.salle.utilities.exceptions.NotFoundException;

public class ConstantUtilities {

    //************************************************************ Database information ******************************************************
    public static final String UsernameBBDD = ""; //Fill it with your own information
    public static final String PasswordBBDD = ""; //Fill it with your own information
    public static final String UrlBDD = "jdbc:oracle:thin:@kali.tecnocampus.cat:1521:sapiens";

    //************************************************************ Console size parameters ***************************************************
    public static final int consoleHorizontal = 90;
    public static final int consoleVertical = 30;

    //************************************************************ Delegation variables ******************************************************
    //Delegation Strings
    public static final String delegationStringBCN = "PS1. PizziSalle Barcelona";
    public static final String delegationStringGIR = "PS2. PizziSalle Girona";
    public static final String delegationStringTAR = "PS3. PizziSalle Tarragona";
    public static final String delegationStringLLE = "PS4. PizziSalle Lleida";
    public static final String delegationStringGENERAL = "PSG. PizziSalle General";

    //Delegation codes
    public static final int delegationBCN = 0;
    public static final int delegationGIR = 1;
    public static final int delegationTAR = 2;
    public static final int delegationLLE = 3;
    public static final int delegationGENERAL = 4;

    //************************************************************ Ingredients strings *******************************************************
    public static final String tomaquet = "Tomaquet";
    public static final String mozzarella = "Mozzarella";
    public static final String pernil = "Pernil";
    public static final String pinya = "Pinya";
    public static final String pollastre = "Pollastre";
    public static final String baconCrispy = "Bacon crispy";
    public static final String frankfurt = "Frankfurt";
    public static final String bacon = "Bacon";
    public static final String ou = "Ou";
    public static final String salsitxes = "Salsitxes";
    public static final String ceba = "Ceba";
    public static final String miniburguers = "Miniburguers";
    public static final String tonyina = "Tonyina";
    public static final String xorico = "Xoriço";
    public static final String olives = "Olives";
    public static final String salsaBBQ = "Salsa BBQ";
    public static final String cheddar = "Cheddar";
    public static final String roquefort = "Roquefort";
    public static final String tomaquetNatural = "Tomaquet natural";
    public static final String anxoves = "Anxoves";
    public static final String gambes = "Gambes";
    public static final String carn = "Carn";
    public static final String salsaCarbonara = "Salsa carbonara";
    public static final String xampinyons = "Xampinyons";
    public static final String pernilSalat = "Pernil salat";
    public static final String brie = "Brie";
    public static final String emmental = "Emmental";
    public static final String pepperoni = "Pepperoni";
    public static final String pebrot = "Pebrot";
    public static final String escarxofa = "Escarxofa";
    public static final String cabra = "Cabra";
    public static final String sobrassada = "Sobrassada";
    public static final String mel = "Mel";

    //************************************************************ Pizza ingredients *********************************************************
    //Basic
    public static final String[] margaridaPizzaIngredients = {};

    //2 ingredients
    public static final String[] hawaianaPizzaIngredients = {pernil, pinya};

    //3 ingredients
    public static final String[] baconcrispyPizzaIngredients = {pernil, pollastre, baconCrispy};
    public static final String[] americanaPizzaIngredients = {frankfurt, bacon, ou};
    public static final String[] traviataPizzaIngredients = {bacon, salsitxes, ceba};

    //4 ingredients
    public static final String[] burguerPizzaIngredients = {miniburguers, ou, bacon, ceba};
    public static final String[] castelleraPizzaIngredients = {ceba, tonyina, xorico, olives};
    public static final String[] cowboyPizzaIngredients = {salsaBBQ, cheddar, roquefort, bacon};
    public static final String[] vaqueraPizzaIngredients = {salsaBBQ, ceba, tomaquetNatural, pollastre};
    public static final String[] marineraPizzaIngredients = {tonyina, anxoves, gambes, pinya};
    public static final String[] bbqPizzaIngredients = {salsaBBQ, carn, bacon, pollastre};
    public static final String[] diabloPizzaIngredients = {pernil, carn, bacon, pollastre};
    public static final String[] carbonaraPizzaIngredients = {salsaCarbonara, bacon, ceba, xampinyons};
    public static final String[] serranaPizzaIngredients = {pernilSalat, brie, olives, xampinyons};
    public static final String[] formatges4PizzaIngredients = {mozzarella, emmental, roquefort, cheddar};
    public static final String[] pepperoniPizzaIngredients = {pepperoni, pernil, carn, bacon};

    //5 ingredeints
    public static final String[] vegetalPizzaIngredients = {ceba, pebrot, tomaquetNatural, escarxofa, xampinyons};
    public static final String[] barcelonaPizzaIngredients = {ceba, carn, brie, pernil, olives};
    public static final String[] gironaPizzaIngredients = {carn, pernil, xampinyons, pollastre, olives};
    public static final String[] tarragonaPizzaIngredients = {tonyina, gambes, ceba, pernil, olives};
    public static final String[] lleidaPizzaIngredients = {salsaBBQ, carn, pollastre, xampinyons, olives};

    //6 ingredients
    public static final String[] formatges6PizzaIngredients = {mozzarella, cabra, brie, emmental, roquefort, cheddar};
    public static final String[] mallorquinaPizzaIngredients = {cabra, emmental, cheddar, brie, sobrassada, olives};
    public static final String[] carbonaradeluxePizzaIngredients = {salsaCarbonara, bacon, ceba, xampinyons, cabra, mel};

    //************************************************************ Pizzas name ***************************************************************
    //Basic
    public static final String margaridaPizzaName = "Margarida";

    //2 ingredients
    public static final String hawaianaPizzaName = "Hawaiana";

    //3 ingredients
    public static final String baconcrispyPizzaName = "Bacon Crispy";
    public static final String americanaPizzaName = "Americana";
    public static final String traviataPizzaName = "Traviata";

    //4 ingredients
    public static final String burguerPizzaName = "Burguer";
    public static final String castelleraPizzaName = "Castellera";
    public static final String cowboyPizzaName = "Cowboy";
    public static final String vaqueraPizzaName = "Vaquera";
    public static final String marineraPizzaName = "Marinera";
    public static final String bbqPizzaName = "Bbq";
    public static final String diabloPizzaName = "Diablo";
    public static final String carbonaraPizzaName = "Carbonara";
    public static final String serranaPizzaName = "Serrana";
    public static final String formatges4PizzaName = "4 formatges";
    public static final String pepperoniPizzaName = "Pepperoni";

    //5 ingredeints
    public static final String vegetalPizzaName = "Vegetal";
    public static final String barcelonaPizzaName = "Barcelona";
    public static final String gironaPizzaName = "Girona";
    public static final String tarragonaPizzaName = "Tarragona";
    public static final String lleidaPizzaName = "Lleida";

    //6 ingredients
    public static final String formatges6PizzaName = "6 formatges";
    public static final String mallorquinaPizzaName = "Mallorquina";
    public static final String carbonaradeluxePizzaName = "Carbonara deluxe";

    //************************************************************ Pizzas code ***************************************************************
    //Basic
    public static final int margaridaPizzaCode = 0;

    //2 ingredients
    public static final int hawaianaPizzaCode = 1;

    //3 ingredients
    public static final int baconcrispyPizzaCode = 2;
    public static final int americanaPizzaCode = 3;
    public static final int traviataPizzaCode = 4;

    //4 ingredients
    public static final int burguerPizzaCode = 5;
    public static final int castelleraPizzaCode = 6;
    public static final int cowboyPizzaCode = 7;
    public static final int vaqueraPizzaCode = 8;
    public static final int marineraPizzaCode = 9;
    public static final int bbqPizzaCode = 10;
    public static final int diabloPizzaCode = 11;
    public static final int carbonaraPizzaCode = 12;
    public static final int serranaPizzaCode = 13;
    public static final int formatges4PizzaCode = 14;
    public static final int pepperoniPizzaCode = 15;

    //5 ingredeints
    public static final int vegetalPizzaCode = 16;
    public static final int barcelonaPizzaCode = 17;
    public static final int gironaPizzaCode = 18;
    public static final int tarragonaPizzaCode = 19;
    public static final int lleidaPizzaCode = 20;

    //6 ingredients
    public static final int formatges6PizzaCode = 21;
    public static final int mallorquinaPizzaCode = 22;
    public static final int carbonaradeluxePizzaCode = 23;

    //Array with all the pizza codes
    public static final int[] allPizzaCodes = {margaridaPizzaCode, hawaianaPizzaCode, baconcrispyPizzaCode, americanaPizzaCode, traviataPizzaCode,
            burguerPizzaCode, castelleraPizzaCode, cowboyPizzaCode, vaqueraPizzaCode, marineraPizzaCode, bbqPizzaCode, diabloPizzaCode, carbonaraPizzaCode,
            serranaPizzaCode, formatges4PizzaCode, pepperoniPizzaCode, vegetalPizzaCode, barcelonaPizzaCode, gironaPizzaCode, tarragonaPizzaCode,
            lleidaPizzaCode, formatges6PizzaCode, mallorquinaPizzaCode, carbonaradeluxePizzaCode};

    //***************************************************** Pizza dough **********************************************************************
    //Strings
    public static final String originalDoughString = "Original";
    public static final String thinDoughString = "Fina";
    public static final String thickDoughString = "Gruixuda";

    //Codes
    public static final int originalDoughCode = 0;
    public static final int thinDoughCode = 1;
    public static final int thickDoughCode = 2;


    //***************************************************** Drinks ***************************************************************************
    public static final String waterDrink = "Aigua";
    public static final String sodaDrink = "Refresc";
    public static final String beerDrink = "Cervesa";
    public static final String[] drinkList = {waterDrink.toUpperCase(), sodaDrink.toUpperCase(), beerDrink.toUpperCase()};

    //***************************************************** Functions ************************************************************************
    //Convert delegation code to delegation string
    public static String getDelegationString(int delegation) throws NotFoundException {
        return switch (delegation) {
            case delegationBCN -> delegationStringBCN;
            case delegationGIR -> delegationStringGIR;
            case delegationTAR -> delegationStringTAR;
            case delegationLLE -> delegationStringLLE;
            case delegationGENERAL -> delegationStringGENERAL;
            default -> throw new NotFoundException("Delegation not found on ConstantUtilities");
        };
    }

    //Convert dough code to dough string
    public static String getDoughString(int doughCode) throws NotFoundException {
        return switch (doughCode) {
            case originalDoughCode -> originalDoughString;
            case thinDoughCode -> thinDoughString;
            case thickDoughCode -> thickDoughString;
            default -> throw new NotFoundException("Delegation not found on ConstantUtilities");
        };
    }
    //************************************************************ API ANSWERS *************************************************************
    public static final int initialPage = 0;
    public static final int clientPhoneNumber = 1;
    public static final int keepRegistering = 2;

    //************************************************************Extra variables*************************************************************
    public static final int ageToBeMajor = 18;
    public static final int maxNumOfIngredients = 12;

    public ConstantUtilities() {
    }
}
