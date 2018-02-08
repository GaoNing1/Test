//package cn.tedu.provider;
//
//import java.util.Hashtable;
//
//import org.osgi.framework.BundleActivator;
//import org.osgi.framework.BundleContext;
//
//
//
//public class Activator implements BundleActivator{
//
//	@Override
//	public void start(BundleContext context) throws Exception {
//		// TODO Auto-generated method stub
//		Hashtable<String, String> props = new Hashtable<String, String>();
//        props.put("Language", "English");
//        context.registerService(
//            DictionaryService.class.getName(), new DictionaryImpl(), props);
//	}
//
//	@Override
//	public void stop(BundleContext context) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//	private static class DictionaryImpl implements DictionaryService
//    {
//       
//        String[] m_dictionary =
//            { "welcome", "to", "the", "osgi", "tutorial" };
//
//      
//        public boolean checkWord(String word)
//        {
//            word = word.toLowerCase();
//
//            // This is very inefficient
//            for (int i = 0; i < m_dictionary.length; i++)
//            {
//                if (m_dictionary[i].equals(word))
//                {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//}
