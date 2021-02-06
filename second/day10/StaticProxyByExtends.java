package second.day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-15
 * Time:19:36
 */
public class StaticProxyByExtends {
    public static void main(String[] args) {
        AliPayServiceProxyByExtends aliPay = new AliPayServiceProxyByExtends();
        WeiXinServiceProxyByExtends weXinPay = new WeiXinServiceProxyByExtends();

        weXinPay.pay();
        aliPay.pay();
    }
}
class AliPayServiceProxyByExtends extends AliPayService {
    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");
        //支付业务逻辑:实际上还是调用的父类的业务
        super.pay();
        //4.时间记录结束
        System.out.println("记录时间结束");
    }
}
class WeiXinServiceProxyByExtends extends WeiXinPayService {
    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");
        //支付业务逻辑:实际上还是调用的父类的业务
        super.pay();
        //4.时间记录结束
        System.out.println("记录时间结束");
    }
}
