package com.springboot.static_resource_handle;

//import org.webjars.WebJarAssetLocator;

/**
 * Created by renwujie on 2018/01/04 at 14:38
 *
 * 然后在页面中使用
 *  <script type="text/javascript" src="${pageContext.request.contextPath }/webjarslocator/jquery/heart.js"></script>
 */
//@Controller
//public class WebJarsController {
//
//    private final WebJarAssetLocator assetLocator = new WebJarAssetLocator();
//
//    @ResponseBody
//    @RequestMapping("/webjarslocator/{webjar}/**")
//    public ResponseEntity<Object> locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
//        try {
//            String mvcPrefix = "/webjarslocator/" + webjar + "/"; // This prefix must match the mapping path!
//            String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//            String fullPath = assetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
//
//            return new ResponseEntity<Object>(new ClassPathResource(fullPath), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
//        }
//    }
//}
