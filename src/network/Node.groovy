package network

import groovy.transform.Canonical;
import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import java.awt.TexturePaintContext.Int;
import java.awt.geom.Arc2D.Double;
import java.lang.reflect.Array;

@Canonical
class Message {
	def cellNumber
	def size
	def time
}

class Cell {
	def messages = [];
	def cellNumber;
	
	def Cell(n) {
		cellNumber = n;
	}
	def receaveMessage(Message m) {
		if (m.cellNumber != cellNumber) {
			messages.add(m)
		}
	}
	def sendMessage() {
		def m = minTimeMessage()
		messages.remove(m)
		m
	}
	def minTimeMessage() {
		def message = new Message(0, 0, 10000000000)
		for (m in messages) {
			if ((message.time <= m.time)== false) {
				message = m
			} 
		}
		message
	}
};