
/*
彩食鲜供应链项目中，在用户的权限管理中使用的ThreadLocal
 */
public final class UserContext {
    private static final ThreadLocal<SecurityUser> context = new ThreadLocal<SecurityUser>();

    private UserContext() {
    }

    public static void setContext(SecurityUser user) {
        context.set(user);
    }
    public static SecurityUser getContext(){
        return (SecurityUser)context.get();
    }
   public static void clear(){
       context.remove();
   }
}
