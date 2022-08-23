package designpattern.chainofresponsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).loggedOn(false).build();
        RequestFrequentHandle requestFrequentHandle = new RequestFrequentHandle(new LoginHandler(null));
        if (requestFrequentHandle.process(request))
        {
            System.out.println("正常业务处理...");
        }
        else {
            System.out.println("访问异常...");
        }
    }
}

class Request {
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(Boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn)
        {
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk)
        {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits)
        {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords)
        {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build()
        {
            Request request = new Request(loggedOn,frequentOk,isPermits,containsSensitiveWords);
            return request;
        }
    }
    public boolean isLoggedOn()
    {
        return loggedOn;
    }

    public boolean isPermits(){
        return isPermits;
    }

    public boolean isFrequentOk()
    {
        return frequentOk;
    }

    public boolean isContainsSensitiveWords()
    {
        return containsSensitiveWords;
    }
}

abstract class  Handler{
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandle extends Handler{

    public RequestFrequentHandle(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制");
        if (request.isFrequentOk())
        {
            Handler next1 = getNext();
            if (next1 == null)
            {
                return true;
            }
            if (!next1.process(request))
            {
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}

class LoginHandler extends Handler{

    public LoginHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证访问...");
        if (request.isLoggedOn())
        {
            Handler next1 = getNext();
            if (null == next1)
            {
                return true;
            }
            if (!next1.process(request)){
                return false;
            }else {
                return true;
            }
        }
        return false;
    }
}
