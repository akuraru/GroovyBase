package network
import static org.junit.Assert.*;

import org.codehaus.groovy.control.customizers.ImportCustomizer.Import;

class NodeTest extends GroovyTestCase {
	def message1 = new Message(0, 1, 0)
	def message2 = new Message(0, 1, 1)
	def message3 = new Message(0, 1, 2)
	
	void test() {
		Cell cell = new Cell()
		assert(cell.messages == [])
	}
	void testCellNum() {
		Cell cell = new Cell(1)
		assert(cell.cellNumber == 1)
	}
	void testReceve() {
		Cell cell = new Cell(1)
		def message = new Message(0, 1, 0)
		cell.receaveMessage(message)
		assert(cell.messages == [message])
	}
	void testReceve2() {
		Cell cell = new Cell(1)
		def message = new Message(1, 1, 0)
		cell.receaveMessage(message)
		assert(cell.messages == [])
	}
	void testMessage() {
		Cell cell = new Cell(1)
		def message = new Message(0, 1, 0)
		cell.receaveMessage(message)
		assert(cell.messages == [new Message(0, 1, 0)])
	}
	void testMinIndex() {
		Cell cell = new Cell(1)
		cell.messages = [message1, message2]
		assert(cell.minTimeMessage() == message1)
	}  
	void testMinIndex2() {
		Cell cell = new Cell(1)
		cell.messages = [message2, message3, message1]
		assert(cell.minTimeMessage() == message1)
	}  
	void testSendMessage() {
		Cell cell = new Cell(1)
		cell.messages = [message2, message3, message1]
		assert(cell.sendMessage() == message1)
		assert(cell.messages == [message2, message3])
	}
	
}
