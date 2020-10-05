package Algorithm.Hash;

public class NobodyListen {

    class Entry{
        int value;
        Entry next;
    }

    static int size;
    static Entry[] hTable;

    public static void main(String[] args){
        size = 10;
        hTable = new Entry[size];


    }

    static int hashMethod(int key){
        return key % size;
    }

    static int getKey(int data){
        return data;
    }

    int add(int data){
        int key = getKey(data);
        int hashValue = hashMethod(key);

        Entry entry = new Entry();
        entry.value = data;

        if(hTable[hashValue] == null){
            hTable[hashValue] = entry;
            return 0;
        }

        Entry pre = null;
        Entry cur = hTable[hashValue];

        while(true){
            if(cur == null){
                hTable[hashValue] = entry;
                return 0;
            }else if(cur.value < key){
                pre = cur;
                cur = cur.next;
            }else{
                if(cur == hTable[hashValue]){
                    entry.next = cur;
                    hTable[hashValue] = entry;
                    return 0;
                }else{
                    entry.next = cur;
                    pre.next = entry;
                    return 0;
                }
            }
        }
    }

    // data가 있는 노드를 반환한다.
    private Entry getEntry(int data){

        int key = getKey(data);
        int hashValue = hashMethod(key);

        // HashTable의 index의  첫번째 노드와 두번째 노드
        Entry pre = hTable[hashValue];
        Entry cur = pre.next;

        while(true){

            if(cur == null){    // 커서 노드가 null 이면 null 반환

                return null;

            }else if(cur.value == key){    // 커서 노드의 값이 키와 같으면 전 노드를 반환

                return pre;

            }else if(cur.value > key){    // 커서의 값이 키보다 크면 null 반환

                return null;

            }else{            // 커서의 값이 키보다 작으면 커서를 다음으로 이동

                pre = cur;
                cur = cur.next;
            }
        }
    }

    // data 를 제거
    public int remove(int data){

        Entry pre = null;

        // data가 있는 노드의 전노드를 가져오고 null이면 -1 반환
        if((pre=getEntry(data))== null){
            return -1;
        }

        // 전 노드가 data의 다음노드를 가리키게 한다.
        // data 노드를 건너뛰게 연결한다 (제거)
        Entry cur = pre.next;
        pre.next = cur.next;
        return 0;
    }

    public String toString(){

        StringBuffer result = new StringBuffer();
        Entry cur = null;

        for(int i=0; i<size; i++){

            result.append("[" + i + "]\t");
            cur = hTable[i];

            if(cur == null){
                result.append("n ");

            }else{

                while(cur!=null){
                    result.append(cur.value + "");
                    cur = cur.next;
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
