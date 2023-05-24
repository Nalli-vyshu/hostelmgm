package com.hostelmgm;

import org.apache.log4j.Logger;

import exception.globalException;

import java.util.*;
import serviceImpl.*;

public class App 
{
	static Logger log=Logger.getLogger(App.class);
	static Scanner bs=new Scanner(System.in);
	static loginregisterImpl ln=new loginregisterImpl();
    public static void main( String[] args ) throws globalException
    {
        log.info( "\t***Welcome To Hostel Management***" );
        
        log.info("\nPress 1 for Registration \n Press 2 for Login");
        
          int ch=bs.nextInt();
          switch(ch) {
          case 1->ln.registartion();
          case 2-> ln.login();
          
          
          }
    }
}
