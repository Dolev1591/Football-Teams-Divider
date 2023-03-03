/*
class MAIN {
    public static void main(String[] args) {
        /*
        Player Lidor = new Player("lidor Adani", 78, 82, 77, 83, 69, 87, 74, 86);
        Player Yair = new Player("Yair Levi", 77, 83, 84, 88, 81, 89, 83, 80);
        Player Zinger = new Player("Itay Zinger", 77, 80, 71, 78, 62, 93, 70, 60);
        Player Yaniv = new Player("Yaniv Adani", 94, 92, 89, 85, 78, 91, 70, 81);
        Player Kenner = new Player("Oz Kenner", 86, 85, 94, 88, 81, 95, 88, 84);
        Player Noam = new Player("Noam Toren", 76, 76, 80, 76, 69, 81, 79, 82);
        Player uri = new Player("uriel hendri", 96, 94, 98, 86, 82, 91, 90, 76);
        Player ido = new Player("Ido Gavriel", 63, 70, 76, 72, 60, 71, 73, 68);
        Player Itzik = new Player("Itzik Lev", 80, 74, 61, 66, 60, 64, 70, 63);
        Player David = new Player("David Volk", 68, 74, 77, 72, 64, 79, 69, 67);
        Player Dolev = new Player("Dolev levy", 63, 70, 77, 72, 62, 73, 85, 66);
        Player Yoni = new Player("Yoni Tal", 82, 77, 80, 79, 94, 79, 88, 95);

        Player[] players = { Lidor, Yair, Zinger, Yaniv, Kenner, Noam, uri, ido, Itzik, David, Dolev, Yoni };
        algo algo= new algo(players);


    }
    */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Combination {
    static int counter=1;
    static void secondGroupFinder(List arr2, List data2, int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data2.get(j)+" ");
            counter++;
            System.out.println("Combination "+counter);
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data2.add(index,arr2.get(i));
            secondGroupFinder(arr2, data2, i+1, end, index+1, r);
        }
    }

            /* arr[] ---> Input Array
            data[] ---> Temporary array to store current combination
            start & end ---> Starting and Ending indexes in arr[]
            index ---> Current index in data[]
            r ---> Size of a combination to be printed */
            static void combinationUtil(List arr, List data, int start,
                                        int end, int index, int r)
            {
                // Current combination is ready to be printed, print it
                if (index == r)
                {
                    for (int j=0; j<r; j++)
                        System.out.println(data.get(j));

                    //filtering
                    List<Integer> tempList= new ArrayList<>(arr);
                    List<Integer> tempData= new ArrayList<>();
                    System.out.println("this is data:"+data);
                    tempList.removeAll(data);
                    System.out.println(tempList);
                    secondGroupFinder(tempList,tempData,0,tempList.size()-1,0,5);
                    System.out.println("");

                    return;
                }

                // replace index with all possible elements. The condition
                // "end-i+1 >= r-index" makes sure that including one element
                // at index will make a combination with remaining elements
                // at remaining positions
                for (int i=start; i<=end && end-i+1 >= r-index; i++)
                {
                    data.(index,arr.get(i));
                    combinationUtil(arr, data, i+1, end, index+1, r);
                }
            }

            // The main function that prints all combinations of size r
            // in arr[] of size n. This function mainly uses combinationUtil()
            static void printCombination(List arr, int n, int r)
            {
                // A temporary array to store all combination one by one
                List<Integer> data = new ArrayList<>();
                HashMap<List, List> AllCombs = new HashMap<List, List>();

                // Print all combination using temporary array 'data[]'
                combinationUtil(arr, data, 0, n-1, 0, r);
            }

            /*Driver function to check for above function*/
            public static void main (String[] args) {
               List<Integer> arr = new ArrayList<Integer>();
                for(int i=1;i<13;i++){
                    arr.add(i);
                }
                System.out.println(arr.toString());
                int r = 5;
                int n = arr.size();
                printCombination(arr, n, r);
            }
        }

        /* This code is contributed by Devesh Agrawal */



