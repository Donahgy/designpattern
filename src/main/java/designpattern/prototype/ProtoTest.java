package designpattern.prototype;

import java.io.*;

public class ProtoTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("xxx");
        Product product = new Product("part1", "part2", 3, 4, baseInfo);
        Product cloneProduct = product.clone();
        System.out.println(product);
        System.out.println(cloneProduct);
        product.getBaseInfo().setCompanyName("aaa");
        System.out.println(product);
        System.out.println(cloneProduct);
    }
}

class BaseInfo implements Cloneable,Serializable {

    static final long serialVersionUID = 42L;

    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        return super.hashCode() + " BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}

class Product implements Cloneable,Serializable {

    static final long serialVersionUID = 42L;

    String part1;
    String part2;
    Integer part3;
    Integer part4;
    Integer part5;
    private BaseInfo baseInfo;

    public Product() {
    }

    public Product(String part1, String part2, Integer part3, Integer part4, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        // v1 通过传统的clone方法实现
//        Product clone = (Product) super.clone();
//        BaseInfo baseInfo1 = this.baseInfo.clone();
//        clone.setBaseInfo(baseInfo1);
//        return clone;
        // v2 通过序列化反序列化实现
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            ObjectInputStream ins = new ObjectInputStream(byteArrayInputStream);
            Product o =(Product) ins.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public Integer getPart5() {
        return part5;
    }

    public void setPart5(Integer part5) {
        this.part5 = part5;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode() + " Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", part5=" + part5 +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
