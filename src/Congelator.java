import java.io.*;

public class Congelator {
    private String brand; 
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

    //2. Afisare vector citit
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

    //3. Cautare dupa brand si pret
    public static void cautare(Congelator [] con, int n, String brand_cautat, int pret_cautat)
    {
        for(int i=0; i<n; i++)
            if(con[i].brand.equals(brand_cautat) && con[i].pret == pret_cautat)
            {
                System.out.println("Congelatorul cautat se afla pe pozitia: " + (i+1));
                return;
            }
        System.out.println("Congelatorul cautat nu exista in vector.");
    }

    //4. Afisare dupa un anumit sistem de racire
    public static int afisareSistemRacire(Congelator [] con, int n, String SisRacire_cautat)
    {
        Congelator aux;
        for (int i=0; i<n; i++)
            if (con[i].sistemRacire.equals(SisRacire_cautat) == false)
            {
                for(int j=i; j<n-1; j++)
                    con[j] = con[j+1];
                n--;
            }
        return n;
    }

    //5. Stergere produse dupa consum anual de energie si culoare
    public static int stergere(Congelator [] con, int n, int s_consEnerg, String s_cul)
    {
        for (int i=0; i<n; i++)
            if (con[i].consumEnergie > s_consEnerg)
            {
                for (int j = i; j< n-1; j++)
                    con[j] = con[j+1];
                n--;
            }

        for (int i=0; i<n; i++)
            if (con[i].culoare.equals(s_cul))
            {
                for (int j = i; j< n-1; j++)
                    con[j] = con[j+1];
                n--;
            }
        return n;
    }

    //6. Ordonare dupa pret
    public static void ordonarePret(Congelator [] con, int n)
    {
        boolean ordonat;
        Congelator aux;

        ordonat = false;
        while(!ordonat)
        {
            ordonat = true;
            for (int i=0; i<n-1; i++)
                if(con[i].pret > con[i+1].pret)
                {
                    aux = con[i];
                    con[i] = con[i+1];
                    con[i+1] = aux;
                    ordonat = false;
                }
        }
        for(int i=0; i<n; i++)
            afisare(con, i);
    }

    //7. Matrice avand pe diagonala principala numarul de compresoare al congelatoarelor si
    //   restul elementelor egale cu 37.
    public static void matrice(Congelator [] con, int n)
    {
        int a[][] = new int[n][n];

        //Creare matrice
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == j)
                    a[i][j] = con[i].numarCompresoare;
                else
                    a[i][j] = 37;
            }
        }

        // Scriere matrice
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Main method
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

        // 3. Cautare dupa brand si pret
        System.out.println("\n3. Cautare congelator dupa brand si pret: ");
        System.out.print("Brandul cautat: ");
        brn = br.readLine();
        System.out.print("Pretul cautat: ");
        prt = Integer.parseInt(br.readLine());
        cautare(con, n, brn, prt);

        // 4. Afisare dupa un anumit sistem de racire
        System.out.println("\n4. Afisare congelatoare cu un anumit sistem de racire: ");
        System.out.print("Sistemul de racire cautat: ");
        sisR = br.readLine();
        n = afisareSistemRacire(con, n, sisR);
        System.out.println();

        for (int i=0; i<n; i++)
            afisare(con, i);

        // 5. Stergere dupa consum anual de energie si culoare
        System.out.println("\n5. Introduceti consumul de energie maxim dorit si culoarea care nu va intereseaza: ");
        System.out.print("Consumul maxim dorit (kWh): ");
        cnsE = Integer.parseInt(br.readLine());
        System.out.print("Culoarea care nu va intereseaza: ");
        cul = br.readLine();

        n = stergere(con, n, cnsE, cul);
        System.out.println();

        for (int i=0; i<n;i++)
            afisare(con, i);

        // 6. Ordonare dupa pret
        System.out.println("\n6. Lista congelatoarelor sortate crescator dupa pret: \n");
        ordonarePret(con, n);

        // 7. Matrice - diagonala principala numar compresoare si restul elementelor nr. 37
        System.out.println("\n7. Matricea este: ");
        matrice(con, n);
    }

}

/* Exemple de date de intrare, luate de pe site-ul Emag:

        Brand           Numar compresoare       Sistem racire       Consum energie      Culoare     Pret
1.      Arctic          2                       Static              257 kWh             Argintiu    1184 RON
2.      Electrolux      1                       No Frost            258 kWh             Alb         1899 RON
3.      Star-Light      2                       Static              238 kWh             Gri         1850 RON
4.      Gorenje         1                       Static              252 kWh             Argintiu    1780 RON
5.      Beko            1                       Static              326 kWh             Alb         1680 RON
6.      Heinner         2                       Static              223 kWh             Gri         949 RON
7.      Liebherr        2                       Smart Frost         175 kWh             Alb         3036 RON
8.      Zanussi         1                       Static              248 kWh             Gri         1421 RON
9.      Miele           1                       Static              241 kWh             Alb         2100 RON
10.     Whirlpool       1                       Static              219 kWh             Argintiu    1700 RON
*/
