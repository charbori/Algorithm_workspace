package LambdaPractice.Model;

public class Member {
    private String name;
    private String id;
    private Address address;

    public Member(String id){
        System.out.println("Member(String id) 실행");
        this.id = id;
    }
    public Member(String name, String id){
        System.out.println("Member(String name, String id) 실행");
        this.id = id;
        this.name = name;
    }
    public Member(String name, String id, Address address){
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName(){ return this.name; }
    public String getId(){ return this.id; }
    public Address getAddress(){ return this.address; }
}
