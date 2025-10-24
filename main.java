package tp5;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        
        Commande c1 = new Commande(1, new Date(), "Manal tizgi ");
        Commande c2 = new Commande(2, new Date(), "Ahmad Ahhh");
        Commande c3 = new Commande(3, new Date(), "Marwa Mouayad");

        
        Client client1 = new Client("C01", "Malak", "Casablanca", "0612345678");
        ClientFidel client2 = new ClientFidel("C02", "Rihab", "Rabat", "0699887766", "FID123", 10.5f);

        
        client1.EnregistrerCommande(c1);
        client1.EnregistrerCommande(c2);
        client1.EnregistrerCommande(c3);
        client2.EnregistrerCommande(c2);

        
        Collections.sort(client1.ListeCommandes, (cmd1, cmd2) -> cmd1.compareTo(cmd2));

        
        Set<Commande> setCommandes = new HashSet<>(client1.ListeCommandes);

        
        Map<String, Client> mapClients = new HashMap<>();
        mapClients.put(client1.toString(), client1);
        mapClients.put(client2.toString(), client2);

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
            for (Client c : Arrays.asList(client1, client2)) {
                writer.write(c.toString());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("✅ Les informations ont été enregistrées dans 'clients.txt'.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l’écriture du fichier : " + e.getMessage());
        }

       
       
        try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture  : " + e.getMessage());
        }
    }
}
