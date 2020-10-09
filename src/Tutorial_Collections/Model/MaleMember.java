package Tutorial_Collections.Model;

import java.util.ArrayList;
import java.util.List;

public class MaleMember {
    private List<Member> list;

    public MaleMember(){
        list = new ArrayList<>();
    }

    public void accumulate(Member member){
        list.add(member);
    }

    public void combine(MaleMember maleList){
        list.addAll(maleList.list);
    }

    public List<Member> getList(){
        return this.list;
    }
}
