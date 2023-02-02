package Day00;

class Person
{
    protected final int IQ  = 140 ;
    protected String  name = null ;
    protected int  age = 0 ;

    static char blood = 'A' ;

    public static void display()
    {
        System.out.printf("blood=%c\n", blood);
//		System.out.printf(
//		  "display()메서드안 name=%s\n",
//		  					name);//error
    }

    //기본생성자(default Constructor)..매개변수가 없음
    public  Person()
    {
        System.out.println("난 Person기본생성자");
        name  = null ;
        age = 0;
    }

    public Person(String name , int  age)
    {
        System.out.println(
                "난 매개변수 두개인 Person 생성자");
        this.name = name ;
        this.age = age;
    }

    public void setAge(int  age)
    {
        this.age = age;
    }
    public int getAge()
    {  return this.age;  }

    public void setName(String  name)
    {	this.name = name ;	}

    public String getName()
    { return  name ;  }

    public 	void  talk()
    {
        name= "아무개";
        System.out.println("talk()메서드이다.");
    }
    public void talk(String shouting)
    {
        System.out.printf("shouting=%s\n",
                shouting);
    }

    public void talk(String shouting ,
                     int page)
    {
        System.out.printf("shouting=%s\n",
                shouting);
        System.out.printf("page=%d\n", page);
    }

    public void talk(int page, String shouting)
    {
        System.out.printf("page=%d\n", page);
        System.out.printf("shouting=%s\n",
                shouting);
    }

    public void breathe()
    { age = 1 ; }
}//end of class Person

class Man extends Day00.Person
{
    final int IQ = 150 ;
    private int money ;
    private  String  job ;

    public String getJob()
    {
        return  job ;
    }

    public void setJob(String  job)
    {
        this.job = job ;
    }

    public Man()
    {
        super() ;
        System.out.println("난 Man의 기본생성자");
    }

    public Man(String name , int age ,
               int money , String  job)
    {
        //super() ; //Person() 호출하라!
        //Person(name ,age);
        super(name ,  age);
        System.out.println("난 인자 4개인 Man생성자");

        //this.name = name ;
        //this.age = age ;
        this.money = money ;
        this.job = job ;
    }

    public void show()
    {
        System.out.printf(
                "Person의 IQ=%d\n", super.IQ);
        System.out.printf(
                "Man의IQ=%d\n", this.IQ);
        System.out.printf("name=%s, age=%d\n" ,
                this.name  ,  age);
        System.out.printf("money=%d , job=%s\n",
                money ,  job );
    }

    public void work()
    { System.out.println("Man 이 일한다.");  }

} //end of Man

public class Inheritance0131 {
    public static void main(String[] args) {

        Day00.Person chulsu = new Day00.Person() ;

        chulsu.name= "철수";
        System.out.printf("chulsu.name=%s\n",
                chulsu.name );

        Day00.Man wonbin = new Day00.Man() ;
        wonbin.setName("원빈");
        wonbin.work() ;
        System.out.printf("wonbin.name=%s\n",
                wonbin.getName() );
        wonbin.setJob("연예인");
        System.out.printf("wonbin.job=%s\n",
                wonbin.getJob() );

        Day00.Man jaesuk = new Day00.Man("유제석", 51,
                70000, "국민MC");
        jaesuk.show();

    }

}




