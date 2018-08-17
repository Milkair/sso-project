package com.amazon.qa.tests;

public class BaseTest {
    protected static final String PLATFORM_VERSION = "7.1.2" ; // it's stark and blanche and Needle and Keira and Mantis device OS "7.1.2"; tank, sloane device 5.1.1
    protected static final String DEVICE_NAME = "ValTank";
    protected static final String PLATFORM_NAME = "Android";
    //rotected static final String AUTOMATION_NAME = "UIAutomator2";


//    protected BasePage page;

//    public enum Apps {
//        HallmarkAppPage("HallmarkAppPage"), CookingChannelAppPage("CookingChannelAppPage");
//
//
//        private final String text;
//
//        /**
//         * @param text
//         */
//        Apps(final String text) {
//            this.text = text;
//        }
//
//        /* (non-Javadoc)
//         * @see java.lang.Enum#toString()
//         */
//        @Override
//        public String toString() {
//            return text;
//        }
//
//        public BasePage getPage(String deviceName, String platformVersion, String platformName) {
//            Class<?> c = null;
//            try {
//                c = Class.forName(text);
//                Constructor<?> cons = c.getConstructor(String.class, String.class, String.class);
//                BasePage page = (BasePage) cons.newInstance(deviceName, platformVersion, platformName);
//                return page;
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//    }
//
//
//    public void initPage(String name, String deviceName, String platformVersion, String platformName) {
//        page = Apps.valueOf(name).getPage(deviceName, platformName, platformName);
//    }

    //initPage("HallmarkAppPage",devName, platV, platN);
}
