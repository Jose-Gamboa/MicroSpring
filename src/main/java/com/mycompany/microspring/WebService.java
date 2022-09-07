package com.mycompany.microspring;

/**
 *
 * @author jose.gamboa
 */
public class WebService {
    
    @RequestMapping("/hWorld")
    public static String helloWorld() {
        return "Hello World";
    }
    
    @RequestMapping("/status")
    public static String status(){
        return "Running";
    } 
}
