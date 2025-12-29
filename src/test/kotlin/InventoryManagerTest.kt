import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.stimmax.ru.stimmax.lessons.lesson30.homework.InventoryManager

class InventoryManagerTest {

    // ---------- getItemCount ----------

    @Test
    fun `getItemCount returns 0 for missing item`() {
        val m = InventoryManager(capacity = 10)
        assertEquals(0, m.getItemCount("apple"))
    }

    @Test
    fun `getItemCount returns correct value for existing item`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 3)
        assertEquals(3, m.getItemCount("apple"))
    }

    // ---------- addItem ----------

    @Test
    fun `addItem adds new item`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 4)
        assertEquals(4, m.getItemCount("apple"))
    }

    @Test
    fun `addItem adds to existing item quantity`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 2)
        m.addItem("apple", 3)
        assertEquals(5, m.getItemCount("apple"))
    }

    @Test
    fun `addItem does not allow zero quantity`() {
        val m = InventoryManager(capacity = 10)
        assertThrows<IllegalArgumentException> {
            m.addItem("apple", 0)
        }
    }

    @Test
    fun `addItem does not allow negative quantity`() {
        val m = InventoryManager(capacity = 10)
        assertThrows<IllegalArgumentException> {
            m.addItem("apple", -1)
        }
    }

    @Test
    fun `addItem throws if capacity exceeded`() {
        val m = InventoryManager(capacity = 5)
        m.addItem("apple", 5)
        assertThrows<IllegalStateException> {
            m.addItem("banana", 1)
        }
    }

    @Test
    fun `addItem allows reaching capacity exactly`() {
        val m = InventoryManager(capacity = 5)
        m.addItem("apple", 2)
        m.addItem("banana", 3)
        assertEquals(2, m.getItemCount("apple"))
        assertEquals(3, m.getItemCount("banana"))
    }

    // ---------- removeItem ----------

    @Test
    fun `removeItem returns false for missing item`() {
        val m = InventoryManager(capacity = 10)
        assertFalse(m.removeItem("apple", 1))
    }

    @Test
    fun `removeItem returns false if not enough quantity`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 2)
        assertFalse(m.removeItem("apple", 3))
        assertEquals(2, m.getItemCount("apple"))
    }

    @Test
    fun `removeItem decreases quantity on success`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 5)
        assertTrue(m.removeItem("apple", 2))
        assertEquals(3, m.getItemCount("apple"))
    }

    @Test
    fun `removeItem removes key when quantity becomes zero`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 3)
        assertTrue(m.removeItem("apple", 3))
        assertEquals(0, m.getItemCount("apple"))
        assertFalse(m.removeItem("apple", 1)) // уже отсутствует
    }

    @Test
    fun `removeItem does not allow zero quantity`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 2)
        assertThrows<IllegalArgumentException> {
            m.removeItem("apple", 0)
        }
    }

    @Test
    fun `removeItem does not allow negative quantity`() {
        val m = InventoryManager(capacity = 10)
        m.addItem("apple", 2)
        assertThrows<IllegalArgumentException> {
            m.removeItem("apple", -1)
        }
    }

    // ---------- constructor validation ----------

    @Test
    fun `capacity cannot be negative`() {
        assertThrows<IllegalArgumentException> {
            InventoryManager(capacity = -1)
        }
    }
}