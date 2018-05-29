package com.lcxs.utils;

import java.util.Random;

public class GetInvitation {
	public static String invitation(){
		String invitation=new Random().nextInt(10000000)+"";
		return (invitation.length()!=6)?invitation():invitation;
	}
}
