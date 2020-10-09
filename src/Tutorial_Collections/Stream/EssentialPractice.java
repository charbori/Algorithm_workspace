package Tutorial_Collections.Stream;

import Algorithm.순열조합.Pair;
import Tutorial_Collections.Model.MaleMember;
import Tutorial_Collections.Model.Member;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EssentialPractice {
    public static void main(String[] args){
        List<String> list = Arrays.asList("홍길동", "김자바", "신용권");

        List<Pair> pList = Arrays.asList(
                new Pair(1,1),
                new Pair(2,1),
                new Pair(3,1),
                new Pair(4,1)
        );
        Stream<Pair> pStream = pList.stream();
        pStream.forEach(p -> {
            System.out.println(p.x + " " + p.y);
        });

        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(EssentialPractice :: print);

        Stream<String> stream = list.stream();
        stream.forEach(EssentialPractice::print);


        List<Member> listMember = Arrays.asList(
                new Member("길동",Member.MALE, 20),
                new Member("홍철",Member.MALE, 26),
                new Member("알카",Member.FEMALE, 27),
                new Member("투썸",Member.MALE, 21),
                new Member("화기",Member.FEMALE, 23)
        );

        Stream<Member> mStream = listMember.stream();
        double val = mStream.filter(m->m.getSex() == Member.MALE)
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();

        System.out.println("평균 나이 : " + val);

        mStream = listMember.stream();
        int countL = (int) mStream.filter(m->m.getSex() == Member.MALE)
                .count();
        System.out.println("남자 수 : " + countL);

        mStream = listMember.stream();
        List<Member> maleListMember = mStream.filter(m->m.getSex() == Member.MALE)
                .collect(Collectors.toList());

        maleListMember.stream().forEach(m->{
            System.out.println(m.getName() + " " + ((m.getSex() == 1) ? "MALE" : "FEMALE") + " " + m.getAge());
        });

        mStream = listMember.stream();
        MaleMember maleMember = mStream.filter(m -> m.getSex() == Member.MALE).collect(MaleMember :: new, MaleMember :: accumulate, MaleMember::combine);
        Supplier<MaleMember> supplier = () -> new MaleMember();
        BiConsumer<MaleMember, Member> accumulator = (ms, s) -> ms.accumulate(s);
        BiConsumer<MaleMember, MaleMember> combiner = (ms1, ms2) -> ms1.combine(ms2);

        maleMember.getList().stream().forEach(m -> System.out.println(m.getSex() + " " + m.getName() + " " + m.getAge()));

        Stream<Member> mStreamBefore = listMember.stream();
        MaleMember maleMember2 = mStreamBefore.filter(m -> m.getSex() == Member.MALE)
                .collect(supplier, accumulator, combiner);
        maleMember2.getList().stream().forEach(m -> System.out.println(m.getSex() + " " + m.getName() + " " + m.getAge()));

    }

    public static void print(String str){
        System.out.println(str + " " + Thread.currentThread().getName());
    }
}
