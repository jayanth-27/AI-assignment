import java.util.*;
class node{
    int nr,nb,max,min;
    node r2,r1,b2,b1;
    node (int nr,int nb,int max,int min)
    {
        this.nr=nr;
        this.nb=nb;
        this.r2=null;
        this.r1=r2;
        this.b1=r2;
        this.b2=b1;
        this.max=max;
        this.min=min;
    }
    
}
class red_blue_nim{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nr=3,nb=3,ver=1,player=-1;
        if (args.length<2)
        {
            System.out.println("Invalid arguments");
            System.exit(0);
        }
        try 
        {
         nr= Integer.parseInt(args[0]);
         nb=Integer.parseInt(args[1]);  
        }
        catch (Exception e)
        {
            System.out.println("Invalid balls");
            System.exit(0);
        }
        if(args.length>3 && (nr<0 || nb<0 ||(!args[2].equals("standard") && !args[2].equals("misere"))|| (!args[3].equals("computer")&&!args[3].equals("human"))))
          {
            System.out.println("Invalid arguments");
            System.exit(0);
          }
        
        else if (args.length==2)
        {
            ver=1;
            player=1;
        }
        else if(args.length==3)
        {
            if(args[2].equals("standard") || args[2].equals("misere"))
            {
                if(args[2].equals("misere"))
                ver=-1;
                player=1;
                
            }
            else if (args[2].equals("computer")||args[2].equals("human"))
            {
                if(args[2].equals("computer"))
                   player=1;
                ver=1;
            }
            else
            {
                System.out.println("Invalid arguments");
            System.exit(0);
            }

        }
        if (args.length==4)
        {
          if(args[2].equals("misere"))
          ver=-1;
          if(args[3].equals("computer"))
           player=1;
        }

        if(nr==0||nb==0)
                {
                if (ver==1) 
                {
                if (player==1)
                System.out.println("You won " + (nr*2+nb*3) +" points");
                else
                  System.out.println("You loose " + (nr*2+nb*3) +" points");
                }
                else{
                    if (player==-1)
                System.out.println("You won " + (nr*2+nb*3) +" points");
                else
                  System.out.println("You loose " + (nr*2+nb*3) +" points");

                }
             System.exit(0);
            }

         if(player==-1)
         {
            System.out.println("Remaining balls");
            System.out.println("Red: "+nr+" Blue: "+nb);
            int move=0;
            while (true)
            {
            System.out.println("Enter you move 1 to 4 as follows");
            System.out.println("1: 2 red balls \n2: 1 red ball \n3: 2 blue balls \n4: 1 blue ball");
            try {
                move=Integer.parseInt(sc.next());
            }
            catch (Exception e)
            {
                move=0;
                System.err.println("Please provide correct data ");

            }
            if(move<1||move>4)
            {
                System.err.println("Please provide correct choice");
            }
            else
            {
                break;
            }
            }
            if(move==1)
                   nr-=2;
                else if (move==2)
                   nr-=1;
                else if(move==3)
                 nb-=2;
                else
                  nb-=1;
                if(nr==0||nb==0)
                 if (ver==1)
                  System.out.println("You won " + (nr*2+nb*3) +" points");
                  else
                  System.out.println("You lost " + (nr*2+nb*3) +" points");
                
         }

        while(nr>0&&nb>0)
        {
            if(ver==1)
            {
                   
               node node=create_minmax_stand(null, -1000000,10000000, nr, nb, -1);
               node temp =choice_stand(node);
               nr=temp.nr;
               nb=temp.nb;
               if(nr==0||nb==0)
               {
                System.out.println("You lost " + (nr*2+nb*3) +" points");
                break;
               }
                System.out.println("Remaining balls");
                System.out.println("Red: "+nr+" Blue: "+nb);
               
                int move=0;
            while (true)
            {
            System.out.println("Enter you move 1 to 4 as follows");
            System.out.println("1: 2 red balls \n2: 1 red ball \n3: 2 blue balls \n4: 1 blue ball");
            try {
             move=Integer.parseInt(sc.next());
            }
            catch (Exception e)
            {
                move=0;
                System.err.println("Please provide correct data ");

            }
            if(move<1||move>4)
            {
                System.err.println("Please provide correct choice");
            }
            else
            {
                break;
            }
            }
                if(move==1)
                   nr-=2;
                else if (move==2)
                   nr-=1;
                else if(move==3)
                 nb-=2;
                else
                  nb-=1;
                if(nr==0||nb==0)
                {
                System.out.println("You won " + (nr*2+nb*3) +" points");
                break;
                }

            }
            else{
                node node=create_minmax_mise(null, -1000000,10000000, nr, nb, 1);
               node temp =choice_mise(node);
               nr=temp.nr;
               nb=temp.nb;
               if(nr==0||nb==0)
                 {System.out.println("You won " + (nr*2+nb*3) +" points");
                 break;}
                System.out.println("Remaining balls");
                System.out.println("Red: "+nr+" Blue: "+nb);
                int move=0;
            while (true)
            {
            System.out.println("Enter you move 1 to 4 as follows");
            System.out.println("1: 2 red balls \n2: 1 red ball \n3: 2 blue balls \n4: 1 blue ball");
            try {
                move=Integer.parseInt(sc.next());
            }
            catch (Exception e)
            {
                move=0;
                System.err.println("Please provide correct data ");

            }
            if(move<1||move>4)
            {
                System.err.println("Please provide correct choice");
            }
            else
            {
                break;
            }
            }
                if(move==1)
                   nr-=2;
                else if (move==2)
                   nr-=1;
                else if(move==3)
                 nb-=2;
                else
                  nb-=1;
                if(nr==0||nb==0)
             {   System.out.println("You lost " + (nr*2+nb*3) +" points");
                break;
            }

            }
        }

        
    }
    public static node choice_mise(node node)
    {
        if (node.b1!=null && node.b1.min==node.max)
            return node.b1;
        if (node.r1!=null && node.r1.min==node.max)
            return node.r1;
        if (node.b2!=null && node.b2.min==node.max)
            return node.b2;
        if (node.r2!=null && node.r2.min==node.max)
            return node.r2;
        return node;
    }
    public static node choice_stand(node node)
    {
        if (node.r2!=null && node.r2.min==node.max)
            return node.r2;
        if (node.b2!=null && node.b2.min==node.max)
            return node.b2;
        if (node.r1!=null && node.r1.min==node.max)
            return node.r1;
        
        if (node.b1!=null && node.b1.min==node.max)
            return node.b1;
        return node;
    }
   public static node create_minmax_stand(node node,int max,int min,int nr,int nb,int player)
   {
    if(nr<0 || nb<0)
    return null;
    node = new node(nr, nb, max, min);
    if (nr==0||nb==0)
    { if (player==-1)
        node.max= Math.max(max, (nr*2+nb*3)*player);
      else
      node.min=Math.min(min,(nr*2+nb*3)*player);
      return node;
    } 
    node.r2= create_minmax_stand(node.r2, max, min, nr-2, nb,player*-1);
    if (node.r2!=null)
    {
        if(player==1){
         node.min=Math.min(min,Math.min(node.r2.max,node.r2.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.r2.max,node.r2.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }
    node.b2= create_minmax_stand(node.b2, max, min, nr, nb-2,player*-1);
    if (node.b2!=null)
    {
        if(player==1){
         node.min=Math.min(min,Math.min(node.b2.max,node.b2.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.b2.max,node.b2.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }
    node.r1= create_minmax_stand(node.r1, max, min, nr-1, nb,player*-1);
    if (node.r1!=null)
    {
        if(player==1){
         node.min=Math.min(min,Math.min(node.r1.max,node.r1.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.r1.max,node.r1.min));
        max=node.max; 
        }
    }
    node.b1= create_minmax_stand(node.b1, max, min, nr, nb-1,player*-1);
    if (node.b1!=null)
    {
        if(player==1){
         node.min=Math.min(min,Math.min(node.b1.max,node.b1.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.b1.max,node.b1.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }
    return node;
   }
   public static node create_minmax_mise(node node,int max,int min,int nr,int nb,int player)
   {

    if(nr<0 || nb<0)
    return null;
    node = new node(nr, nb, max, min);
    if (nr==0||nb==0)
    { if (player==1)
        node.max= Math.max(max, (nr*2+nb*3)*player);
      else
      node.min=Math.min(min,(nr*2+nb*3)*player);
      return node;
    } 
    node.b1= create_minmax_mise(node.b1, max, min, nr, nb-1,player*-1);
    if (node.b1!=null)
    {
        if(player==-1){
         node.min=Math.min(min,Math.min(node.b1.max,node.b1.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.b1.max,node.b1.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }
    node.r1= create_minmax_mise(node.r1, max, min, nr-1, nb,player*-1);
    if (node.r1!=null)
    {
        if(player==-1){
         node.min=Math.min(min,Math.min(node.r1.max,node.r1.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.r1.max,node.r1.min));
        max=node.max; 
        }
    }
    node.b2= create_minmax_mise(node.b2, max, min, nr, nb-2,player*-1);
    if (node.b2!=null)
    {
        if(player==-1){
         node.min=Math.min(min,Math.min(node.b2.max,node.b2.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.b2.max,node.b2.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }
    node.r2= create_minmax_mise(node.r2, max, min, nr-2, nb,player*-1);
    if (node.r2!=null)
    {
        if(player==-1){
         node.min=Math.min(min,Math.min(node.r2.max,node.r2.min));
         min=node.min;
        }
         else{
         node.max=Math.max(max,Math.max(node.r2.max,node.r2.min));
        max=node.max; 
        }
    }
    if (max>=min)
    {
        return node;
    }

    return node;
   }
}