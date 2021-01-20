package L4;

import java.util.Scanner;
import java.util.*;
import java.io.IOException;

public class Exception1 extends Exception{
private String message;
public  String Exception(String num){
    message = num;
    return message;
   }
}