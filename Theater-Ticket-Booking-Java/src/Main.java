import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("             ----------------------------          ");
        System.out.println("              VARANASHI CINEMAS- Tiruppur          ");
        System.out.println("             ----------------------------          ");
        System.out.println(" --------------------------------------------------");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|           ALL EYES THIS SIDE PLEASE             |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|              4K dolby atmos/dolby vision screen |");
        System.out.println("--------------------------------------------------");
        char seats[][]=new char[10][28];
        for(char a[]:seats) {
            Arrays.fill(a,'0');
        }
        printSeats(seats);
        int totalseat=totalSeatsAvailable(seats);
        System.out.println("Total seats available :"+totalseat);
        LinkedHashMap<String,Integer> ticketPrice=new LinkedHashMap<>();
        ticketPrice.put("SILVER",80);
        ticketPrice.put("GOLD",120);
        ticketPrice.put("PLATINUM",180);
        ticketPrice.put("DIAMOND",240);
        System.out.println("===================================================");
        System.out.println();
        System.out.println();
        printPrice(ticketPrice);
        System.out.println("Press 1 to start. 0 to exit");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        while (x!=0)
        {
            System.out.println("1.Book Tickets        ");
            System.out.println("2.View Balance Tickets");
            System.out.print("Enter your choice\n");
            x=sc.nextInt();
            if(x==1)
            {
                printDesign(seats);
                printPrice(ticketPrice);
                System.out.println("Enter the category!");
                sc.nextLine();
                String m= sc.nextLine();
                System.out.println("Enter the total no. tickets:");
                int n= sc.nextInt();
                int remaining=remainingTickets(m,seats);
                if(remaining>=n) {
                    System.out.println("Tickets are available ....");
                    System.out.println("Loading......");
                    if(MarkSeats(m, seats,n)) {
                        printDesign(seats);
                        printSeats(seats);
                        int price = ticketPrice.get(m.toUpperCase()) * n;
                        System.out.println(n + " X " + (price / n) + " = " + price);
                    }
                }
                else{
                    System.out.println("Sorry. we have only! "+remaining+" Tickets left! at "+m);
                }
            }
            else if(x==2)
            {

            }
        }
    }
    public static boolean MarkSeats(String m,char arr[][],int n)
    {
        if(m.equals("SILVER"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(ans==n)
                    {
                        return true;
                    }
                    if(i==0 || i==1)
                    {
                        if(arr[i][j]!='X')
                        {
                            arr[i][j]='X';
                            ans++;
                        }
                    }
                }
            }
            return false;
        }
        else if(m.equals("GOLD"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(ans==n)
                    {
                        return true;
                    }
                    if(i==2 || i==3)
                    {
                        if(arr[i][j]!='X')
                        {
                            arr[i][j]='X';
                            ans++;
                        }
                    }
                }
            }
            return false;
        }
        else if(m.equals("PLATINUM"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(ans==n)
                    {
                        return true;
                    }
                    if(i==4 || i==5 || i==6)
                    {
                        if(arr[i][j]!='X')
                        {
                            arr[i][j]='X';
                            ans++;
                        }
                    }
                }
            }
            return false;
        }
        else if(m.equals("DIAMOND"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(ans==n)
                    {
                        return true;
                    }
                    if(i==10)
                    {
                        if(arr[i][j]!='X')
                        {
                            arr[i][j]='X';
                            ans++;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    public static int remainingTickets(String m,char arr[][])
    {
        if(m.equals("SILVER"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(i==0 || i==1)
                    {
                        if(arr[i][j]!='X')
                        {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
        else if(m.equals("GOLD"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(i==2 || i==3)
                    {
                        if(arr[i][j]!='X')
                        {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
        else if(m.equals("PLATINUM"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(i==4 || i==5 || i==6)
                    {
                        if(arr[i][j]!='X')
                        {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
        else if(m.equals("DIAMOND"))
        {
            int ans=0;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<arr[0].length;j++)
                {
                    if(i==10)
                    {
                        if(arr[i][j]!='X')
                        {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
        return -1;
    }
   public static void printSeats(char arr[][])
   {
       for(int i=0;i<arr.length;i++)
       {
           for(int j=0;j<arr[0].length;j++)
           {
               if( j!=10 && j!=11 && j!=12 && j!=13 && j!=14) {
                   System.out.print(arr[i][j] + " ");
               }
               else {
                   System.out.print(" ");
               }
           }
           System.out.println();
           if(i==arr.length-2)
           {
               System.out.println("                                                      ");
           }

       }
   }
   public static void printDesign(char seats[][])
   {
       System.out.println("             -----------------------------              ");
       System.out.println("             |VARANASHI CINEMAS- Tiruppur|              ");
       System.out.println("             -----------------------------              ");
       System.out.println(" --------------------------------------------------");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|           ALL EYES THIS SIDE PLEASE             |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|                                                 |");
       System.out.println("|               4K dolby atmos/dolby vision screen|");
       System.out.println("--------------------------------------------------");
       int totalseat=totalSeatsAvailable(seats);
       System.out.println("Total seats available :"+totalseat);
       LinkedHashMap<String,Integer> ticketPrice=new LinkedHashMap<>();
       ticketPrice.put("SILVER              ",80);
       ticketPrice.put("GOLD                ",120);
       ticketPrice.put("PLATINUM            ",180);
       ticketPrice.put("DIAMOND             ",240);
       System.out.println("====================================================");
   }
   public static int totalSeatsAvailable(char arr[][])
   {
       int count=0;
       for(int i=0;i<arr.length;i++)
       {
           for(int j=0;j<arr[0].length;j++)
           {
               if(arr[i][j]!='X' && ( j!=10 && j!=11 && j!=12 && j!=13 && j!=14))
               {
                   count++;
               }
           }
       }
       return count;
   }
   public static void printPrice(LinkedHashMap<String,Integer> hm)
   {
       System.out.println("TICKET PRICE");
       System.out.println("--------------------------------------");
       for(Map.Entry<String,Integer> e:hm.entrySet())
       {
           System.out.println("|       "+e.getKey()+" | "+e.getValue()+"₹"+"     ");
       }
       System.out.println("--------------------------------------");
   }
}