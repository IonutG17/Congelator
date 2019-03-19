import java.io.*;

public class Congelator {
    private String brand; //model?! adica numele gen Zanussi A380...or someth?!
    private int numarCompresoare;
    private String sistemRacire;
    private int consumEnergie;
    private String culoare;
    private int pret;

    //Constructor
    public Congelator(String b, int nc, String sr, int ce, String c, int p)
    {
        brand = b;
        numarCompresoare = nc;
        sistemRacire = sr;
        consumEnergie = ce;
        culoare = c;
        pret = p;
    }

    //Afisare
    public static void afisare(Congelator [] con, int i)
    {
        System.out.println("Brand congelator: " + con[i].brand);
        System.out.println("Numar compresoare: " + con[i].numarCompresoare);
        System.out.println("Sistem racire: " + con[i].sistemRacire);
        System.out.println("Consum energie (Kwh): " + con[i].consumEnergie);
        System.out.println("Culoare: " + con[i].culoare);
        System.out.println("Pret (RON): " + con[i].pret);
        System.out.println("------------------------------------");
    }



    //Sortare dupa pret
    public static void sortare(Congelator [] tel, int n)
    {
        boolean ordonat;
        Congelator aux;

        ordonat = false;
        while(!ordonat)
        {
            ordonat = true;
            for (int i=0; i<n-1; i++)
                if(tel[i].pret > tel[i+1].pret)
                {
                    aux = tel[i];
                    tel[i] = tel[i+1];
                    tel[i+1] = aux;
                    ordonat = false;
                }
        }

        for(int i=0; i<n; i++)
            afisare(tel, i);
    }

    //Main
    public static void main(String [] args) throws Exception{

        Congelator [] con = new Congelator[20];
        int n;
        String brn, sisR, cul;
        int nmrC, cnsE, prt;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("1. Introduceti numarul de congelatoare pe care le doriti inserate in vector: ");
        n = Integer.parseInt(br.readLine());

        // 1. Citire vector congelatoare
        for(int i = 0; i<n; i++)
        {
            System.out.print("\nIntroduceti brandul congelatorului " + (i+1) + ": ");
            brn = br.readLine();
            System.out.print("Introduceti numarul de compresoare al congelatorului " + (i+1) + ": ");
            nmrC = Integer.parseInt(br.readLine());
            System.out.print("Introduceti sistemul de racire al congelatorului " + (i+1) + ": ");
            sisR = br.readLine();
            System.out.print("Introduceti consumul anual de energie al congelatorului " + (i+1) + " (kWh): ");
            cnsE = Integer.parseInt(br.readLine());
            System.out.print("Introduceti culoarea congelatorului " + (i+1) + ": ");
            cul = br.readLine();
            System.out.print("Introduceti pretul congelatorului " + (i+1) + " (RON): ");
            prt = Integer.parseInt(br.readLine());

            con [i] = new Congelator(brn, nmrC, sisR, cnsE, cul, prt);
        }

        // 2. Afisare vector congelatoare introduse
        System.out.println("\n2. Lista congelatoarelor introduse este: \n");
        for(int i = 0; i<n; i++)
        {
            afisare(con, i);
        }

        // 3. Cautare dupa...

        // 4. Cautare dupa sistem de racire

        // 5. Stergere dupa consum anual de energie si culoare

        // 6. Sortare dupa pret
        System.out.println("\n6. Lista congelatoarelor sortate crescator dupa pret: \n");
        sortare(con, n);

        // 7. Matrice diagonala principala numar compresoare si restul elementelor nr. 37

    }

}

/* Exemple de date de intrare, luate de pe siteul Emag:

        Brand           Numar compresoare       Sistem racire       Consum energie      Culoare     Pret
1.      Arctic          1                       Static              257 kWh             Alb         1184 RON
2.      Electrolux      1                       No Frost            258 kWh             Alb         1899 RON
3.      Star-Light      1                       Static              238 kWh             Alb         850 RON
4.      Gorenje         1                       Static              252 kWh             Alb         1780 RON
5.      Beko            2                       No Frost            326 kWh             Argintiu    1680 RON
6.      Heinner         1                       Static              223 kWh             Alb         949 RON
7.      Liebherr        2                       Smart Frost         175 kWh             Alb         3036 RON
8.      Zanussi         1                       Static              248 kWh             Gri         1421 RON
*/