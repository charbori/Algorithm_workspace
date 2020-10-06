package MultiTasking.ThreadPool;

import MultiTasking.ThreadPool.Model.Pair;

import java.io.UnsupportedEncodingException;
import java.nio.channels.CompletionHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.*;

public class Practice2 {
    ExecutorService executorService;
    CompletionService completionService;

    public Practice2(ExecutorService executorService){
        this.executorService = executorService;
        this.completionService = new ExecutorCompletionService(executorService);
    }

    public CompletionHandler<Pair, Void> callback = new CompletionHandler() {
        @Override
        public void completed(Object result, Object attachment) {
            Pair temp = (Pair) result;
            System.out.println(temp.key + " " + temp.data);
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("error");
        }
    };
    public String hashing(String str){
        StringBuffer hexString = new StringBuffer();
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));

            for(int i=0;i<hash.length;i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return hexString.toString();
    }

    public String md5Hashing(String str){
        StringBuffer md5buffer = new StringBuffer();
        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
            digest.digest(str.getBytes());
            byte[] md5Code = digest.digest();
            for(int i=0;i<md5Code.length;i++){
                String md5Char = String.format("%02x",0xff&(char)md5Code[i]);
                md5buffer.append(md5Char);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5buffer.toString();
    }

    public void doWorkHasing(Pair p){
        Runnable Task = new Runnable(){
            @Override
            public void run(){
                try{
                    p.key = hashing(p.key);
                    callback.completed(p, null);
                }catch (NumberFormatException e){
                    callback.failed(e, null);
                }
            }
        };

        executorService.submit(Task);
    }

    public void doWorkMD5Hasing(Pair p){
        Runnable Task = new Runnable(){
            @Override
            public void run(){
                try{
                    p.key = md5Hashing(p.key);
                    callback.completed(p, null);
                }catch (NumberFormatException e){
                    callback.failed(e, null);
                }
            }
        };

        executorService.submit(Task);
    }

    public void doCallable(Pair p){
        Callable<Pair> callable = new Callable() {
            @Override
            public Pair call() throws Exception {
                p.key = hashing(p.key);
                return p;
            }
        };
        completionService.submit(callable);
        completionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                p.key = hashing(p.key);
                Thread.sleep(1000);
                return p;
            }
        });
        completionService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                p.key = md5Hashing(p.key);
                Thread.sleep(2000);
                return p;
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Future<Pair> future = completionService.take();
                        Pair value = future.get();
                        System.out.println("[처리 결과] " + value.key);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
    }

    public void finish(){
        executorService.shutdownNow();
    }

    public static void main(String[] args){
        Practice2 practice2 = new Practice2(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

        Pair p = new Pair("kim", 111);
        practice2.doWorkHasing(p);
        Pair p2 = new Pair("kim", 111);
        Pair p3 = new Pair("kim", 111);
        practice2.doWorkMD5Hasing(p2);
        practice2.doCallable(p3);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        practice2.finish();

    }
}
