package second.day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-15
 * Time:19:32
 */


public class AliPayService implements PayService{
    @Override
    public void pay() {
        //1.安全检查
        System.out.println("安全检查");
        //2.记录日志
        System.out.println("记录日志");
        //3.时间统计开始
        System.out.println("记录开始时间");
        //支付业务逻辑
        System.out.println("支付宝支付...");
        //4.时间记录结束
        System.out.println("记录时间结束");
    }
}
