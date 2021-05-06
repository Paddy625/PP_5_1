package pp_5_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class pierwszaKlasa {
	  public static void main(String[] args){
		  RandomNumberGenerator rng = new RandomNumberGenerator(1);
          List<Integer> values = new ArrayList<Integer>();
          List<Integer> weight = new ArrayList<Integer>();
          int cost = 0;
          int load = 0;
          pierwszaKlasa outer = new pierwszaKlasa();
          result res = outer.new result(0, 0);
          Scanner in = new Scanner(System.in);
          
          // === Ustalanie zmiennych ===
          System.out.print("Podaj ilosc przedmiotów: ");
          int count = in.nextInt();
          System.out.print("Podaj maksymaln¹ wagê przedmiotów: ");
          int weightMax = in.nextInt();
          System.out.print("Podaj maksymaln¹ wartosc przedmiotów: "); 
          int valueMax = in.nextInt();
          System.out.print("Podaj pojemnoœæ plecaka: ");
          int capacity = in.nextInt();
         
          // === Losowanie przedmiotów ===
          for (int i = 0; i < count; i++)
              values.add(rng.nextInt(1, valueMax));
          for (int i = 0; i < count; i++)
              weight.add(rng.nextInt(1, weightMax));

          // === Wyœwietlanie przedmiotów ===
          DisplayObjects(values, weight);

          // === Problem plecakowy ===
          res = knapsack(weight, values, capacity);
          if (res != null)
          {
        	  System.out.print("\nWartoœæ wybranych przedmiotów wynosi:\t" + res.cost);
        	  System.out.print("\nWaga wybranych przedmiotów wynosi:\t" + res.load);
              return;
          }
          else
              return;
	  }
	  
	  // === Struktura zawieraj¹ca rozwi¹zanie problemu plecakowego ===
      public class result
      {
          public int load;
          public int cost;
          public List<Integer> packed;
          public result(int x, int y)
          {
              cost = x;
              load = y;
              packed = new ArrayList<Integer>();
          }
      }
      // ==============================================================

      // === Problem plecakowy - rozwiazanie naiwne =======================================
      public static result knapsack(List<Integer> weight, List<Integer> values, int capacity)
      {
          if (capacity == 0)
          {
        	  System.out.print("Zerowa pojemnoœæ plecaka!");
              return null;
          }
          else
          {
        	  pierwszaKlasa outer = new pierwszaKlasa();
              result res = outer.new result(0, 0);
              System.out.print("\nWybrano przedmioty o numerach:");
              for (int i = 0; i < values.size(); i++)
              {
                  if (res.load + weight.get(i) <= capacity)
                  {
                      res.load = res.load + weight.get(i);
                      res.cost = res.cost + values.get(i);
                      res.packed.add(i + 1);
                      System.out.print("\t" + (i + 1));
                  }
              }
              if (values.size() == 0)
              {
            	  System.out.print("Brak przedmiotów mieszcz¹cych siê w plecaku!");
                  return null;
              }
              else
                  return res;
          }
      }
      // ==================================================================================

      // === Wyœwietlanie przedmiotów ==============================
      static void DisplayObjects(List<Integer> values, List<Integer> weight)
      {
    	  System.out.print("\nN:\t");
          for (int i = 0; i < values.size(); i++)
        	  System.out.print(i + 1 + "\t");
          System.out.print("\nW:\t");
          for (int i = 0; i < weight.size(); i++)
    	       System.out.print(weight.get(i) + "\t");
    	  System.out.print("\nV:\t");
    	  for (int i = 0; i < values.size(); i++)
    	      System.out.print(values.get(i) + "\t");
          System.out.print("\n");
          return;
      }
      // ===========================================================
}