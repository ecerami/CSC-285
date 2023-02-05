package edu.bhcc;

/**
 * Simulate TicketMaster Selling Lots of Tickets.
 */
public class TicketMaster {
    private int numTicketsToSell;

    /**
     * Constructor with total number of tickets available to sell.
     * @param numTicketsToSell
     */
    public TicketMaster(int numTicketsToSell) {
        this.numTicketsToSell = numTicketsToSell;
    }

    /**
     * Buy a Single Ticket.  Not thread-safe.
     */
    public void buyTicket() {
        int updatedNumTickets = numTicketsToSell - 1;

        // Introduce a tiny delay to magnify the problem.
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.numTicketsToSell = updatedNumTickets;
    }

    /**
     * Get Number of Tickets Left to Sell.
     */
    public int getNumTicketsToSell() {
        return numTicketsToSell;
    }
}
