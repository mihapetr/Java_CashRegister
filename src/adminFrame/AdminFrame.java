
package adminFrame;

import general.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mihael
 */
/*
This is an example of a frame for the administrator. 
It doesn't have the "main" function. The "Main" class takes care of displaying and 
destruction.
Variable "done" is used for signaling to Main when to transition to the previous frame.
Setting "done" to "true" will cause the frame's distruction and the end user will
be prompted with the login window again.
A full implementation is needed for this class. See documentation. 
*/
public class AdminFrame extends javax.swing.JFrame {

    public boolean done;
    Map<String, JCheckBox> grid;
    TreeMap<String, ArrayList<String>> meals;
    TreeMap<String, ArrayList<String>> workers;
    
    DatabaseConnection database;
    /**
     * Creates new form adminFrame
     * @throws java.sql.SQLException
     */
    public AdminFrame() throws SQLException {
        done = false;
        grid = new HashMap<String, JCheckBox>();
        database = new DatabaseConnection();
        meals = new TreeMap<>();
        workers = new TreeMap<>();
        initComponents();
        
        displayMeals(); // Prikazujemo popis svih jela iz baze podataka
        //MIHAEL EDIT: prikazujemo popis u tablici hrane
        getMeals();
        showMealsTable();
        getWorkers();
        showWorkersTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        mealsPanel = new javax.swing.JPanel();
        mealsPanelLabel = new javax.swing.JLabel();
        foodDataLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        addMeal = new javax.swing.JButton();
        deleteMeal = new javax.swing.JButton();
        workersDataLabel = new javax.swing.JLabel();
        addWorker = new javax.swing.JButton();
        removeWorker = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHrana = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRadnik = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setText("Odjava");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        mealsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout mealsPanelLayout = new javax.swing.GroupLayout(mealsPanel);
        mealsPanel.setLayout(mealsPanelLayout);
        mealsPanelLayout.setHorizontalGroup(
            mealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        mealsPanelLayout.setVerticalGroup(
            mealsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        mealsPanelLabel.setText("Klikom miša odaberite dostupnost pojedinog artikla iz baze podataka.");

        foodDataLabel.setText("Podaci o hrani:");

        saveButton.setText("Primijeni");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        addMeal.setText("Dodaj");
        addMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMealActionPerformed(evt);
            }
        });

        deleteMeal.setText("Izbaci");
        deleteMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMealActionPerformed(evt);
            }
        });

        workersDataLabel.setText("Podaci o zaposlenicima:");

        addWorker.setText("Dodaj");
        addWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkerActionPerformed(evt);
            }
        });

        removeWorker.setText("Izbaci");
        removeWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWorkerActionPerformed(evt);
            }
        });

        tableHrana.setAutoCreateRowSorter(true);
        tableHrana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAZIV", "KRATKI NAZIV", "CIJENA", "% SUBVENCIJE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHrana.setToolTipText("");
        tableHrana.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableHrana);

        tableRadnik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USERNAME", "LOZINKA", "IME", "PREZIME", "ADMIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableRadnik);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addWorker)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(removeWorker))
                                    .addComponent(workersDataLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addMeal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteMeal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(foodDataLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutButton)
                            .addComponent(mealsPanelLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mealsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addMeal, deleteMeal});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addWorker, removeWorker});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mealsPanelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton)
                    .addComponent(mealsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workersDataLabel)
                    .addComponent(foodDataLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWorker)
                    .addComponent(removeWorker)
                    .addComponent(addMeal)
                    .addComponent(deleteMeal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        try{
        DatabaseConnection.conn.close();}
        catch(Exception e){}
        done = true;
    }//GEN-LAST:event_logoutButtonActionPerformed

    public void goodSave() {
        JOptionPane.showMessageDialog(this, "Promjene dostupnosti uspješno spremljene!");
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
            //will be implemented as a background task
            SaveGrid task = new SaveGrid(this);
            task.execute();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMealActionPerformed
        // TODO add your handling code here:
        addMealDialog();
    }//GEN-LAST:event_addMealActionPerformed

    private void deleteMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMealActionPerformed
        // TODO add your handling code here:
        removeMealDialog();
    }//GEN-LAST:event_deleteMealActionPerformed

    private void addWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkerActionPerformed
        // TODO add your handling code here:
        addWorkerDialog();
    }//GEN-LAST:event_addWorkerActionPerformed

    private void removeWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWorkerActionPerformed
        // TODO add your handling code here:
        removeWorkerDialog();
    }//GEN-LAST:event_removeWorkerActionPerformed
    
    // Metoda koja unutar framea prikazuje popis svih jela iz baze podataka
    private void displayMeals() throws SQLException {
        System.out.println("Retrieving all meals from database...");
        
        // Dohvacamo sva jela iz baze
        ResultSet resultSet = retrieveMealsFromDatabase();
        
        mealsPanel.setLayout(new GridLayout(0, 5));
        
        // Prolazimo po svakom dohvacenom jelu...
        while (resultSet.next()) {
            String mealName = resultSet.getString("NAZIV").toLowerCase();
            String mealAvailability = resultSet.getString("DOSTUPAN");
            // Nad-panelu dodajemo upravo panel (jelo i dostupnost)
            
            /*
            MIHAEL EDIT: 
            - spremam parove (name, checkBox) u mapu da se mogu dohvaćati 
            odabrane boolean vrijednosti kod spremaja promjena u bazu
            */
            
           JCheckBox nmc = newMealCheckBox(
                    mealName,
                    stringToBoolean(mealAvailability));
           
            mealsPanel.add(nmc);
            
            grid.put(mealName, nmc);
            
        }
        
        // Prilagodjavamo velicinu framea
        pack();
    }
    
    // Metoda koja iz baze podataka dohvaca sva jela
    ResultSet retrieveMealsFromDatabase() throws SQLException {
        String sqlStatement = "SELECT NAZIV, DOSTUPAN FROM Hrana";
        
        // Izvrsavamo upit i dajemo dobivenu tablicu kao povratnu vrijednost
        ResultSet resultSet = database.executeSelect(sqlStatement);        
        System.out.println("Meals retrievement done.\n");        
        
        return resultSet;
    }
    
    // Metoda koja popunjava pod-panel unutar panela sa svim jelima
    JCheckBox newMealCheckBox(
            String mealName,
            boolean mealAvailability) {
        // Stvaramo checkbox koji predstavlja dano jelo iz baze
        JCheckBox mealCheckBox = new JCheckBox(mealName);
        
        // Ako je jelo iz baze dostupno, to oznacavamo kvacicom
        if (mealAvailability) mealCheckBox.setSelected(true);
        
        // Vracamo checkbox koji predstavlja dostupnost jela iz baze
        return mealCheckBox;
    }
    
    // Metoda koja string pretvara u boolean
    boolean stringToBoolean(String stringRepresentation) {
        return stringRepresentation.equals("true");
    }
    
    /*
    MIHAEL EDIT:
    - funkcija za spremanje promjena dostupnosti artikala
    - biti će background task
    */
    
    
    // Metoda koja iz baze podataka dohvaca jela (kopija modificirana)
    void getMeals() throws SQLException {
        String sqlStatement = "SELECT NAZIV, KRATKI_NAZIV, CIJENA, RAZINA_SUBVENCIJE "
                + "FROM Hrana";
        
        // Ostvarujemo konekciju s bazom podataka
        DatabaseConnection database = new DatabaseConnection();
        
        // Izvrsavamo upit i pohranjujemo dobivenu tablicu
        ResultSet resultSet = database.executeSelect(sqlStatement);        
        System.out.println("Meals retrievement done.\n");        
        
        // Prolazimo po dobivenoj tablici...
        while (resultSet.next()) {
            String name = resultSet.getString("NAZIV");
            String shortName = resultSet.getString("KRATKI_NAZIV");
            String price = Float.toString(resultSet.getFloat("CIJENA"));
            String subsidy = Float.toString(resultSet.getFloat("RAZINA_SUBVENCIJE"));
            
            ArrayList<String> data = new ArrayList<>(
                    Arrays.asList(shortName, price, subsidy));

            // Svako jelo dodajemo u mapu:
            meals.put(name, data);
        }
    }
    
    public DefaultTableModel model;
    
    void showMealsTable() {
        model = (DefaultTableModel) tableHrana.getModel();
        ArrayList<String> L;
        //dodajemo redke u tablicu hrane
        for(Map.Entry<String, ArrayList<String>> e : meals.entrySet()) {
            L = e.getValue();
            model.addRow(new Object[]{
                e.getKey(),
                L.get(0),
                Float.parseFloat(L.get(1)),
                Float.parseFloat(L.get(2))
            });
        }
    }
    
    void addRow(Object[] row) throws SQLException {
        String sql = "insert into Hrana(NAZIV, CIJENA, KRATKI_NAZIV, RAZINA_SUBVENCIJE, DOSTUPAN) "
                + "values(?, ?, ?, ?, ?)";
        PreparedStatement pstmt =  DatabaseConnection.conn.prepareStatement(sql);
        pstmt.setString(1, row[0].toString());
        pstmt.setString(2, row[2].toString());
        pstmt.setString(3, row[1].toString());
        pstmt.setString(4, row[3].toString());
        pstmt.setString(5, "false");
        AddMeal ss = new AddMeal(pstmt, this, row);
        ss.execute();
    }
    
    void addMealDialog() {
        String input = JOptionPane.showInputDialog(
                null, "NAZIV,kratki_naziv,cijena,%_subvencije");
        if(input == null) return;
        
        //if (!validateInput(input)) return;
        String[] inputs = input.split(",");
        
        try{
            Object[] row = new Object[]{inputs[0].toString().toUpperCase(),inputs[1].toString(),Float.parseFloat(inputs[2]),Float.parseFloat(inputs[3])};
            addRow(row);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this,
      "Pogrešno uneseni podaci. Pokušajte ponovo");
        }

        
    }
    
    void addToPanel(String name) {
        JCheckBox nmc = newMealCheckBox(
                    name,
                    false);
           
            mealsPanel.add(nmc);
            
            grid.put(name, nmc);
    }
   
    
    void removeFromPanel(String key) {
        //System.out.println(key);
        //mealsPanel.remove(grid.get(key));
        JCheckBox check = grid.get(key);
        //mealsPanel.remove(check);
        check.setEnabled(false);
        grid.remove(key);
    }

    
    void removeMealDialog() {
        int selection = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da želite izbrisati označene artikle?");
        //System.out.println(selection);
        if(selection == 0) {
            int [] rows = tableHrana.getSelectedRows();
            if(rows.length > 1) {
                JOptionPane.showMessageDialog(this, "Molim odaberite samo jedan artikl.");
            }
            else {
                RemoveMeal task = new RemoveMeal(rows, this);
                task.execute();
            }
        }
        
        //model.getValueAt(1, 1);
    }
    
    void getWorkers() throws SQLException {
        String sqlStatement = "SELECT KORISNICKO_IME, LOZINKA, IME, PREZIME, ULOGA "
                + "FROM Radnik";
        
        // Izvrsavamo upit i pohranjujemo dobivenu tablicu
        ResultSet resultSet = database.executeSelect(sqlStatement);        
        System.out.println("Meals retrievement done.\n");        
        
        // Prolazimo po dobivenoj tablici...
        while (resultSet.next()) {
            String username = resultSet.getString("KORISNICKO_IME");
            String password = resultSet.getString("LOZINKA");
            String name = resultSet.getString("IME");
            String surname = resultSet.getString("PREZIME");
            String role = resultSet.getString("ULOGA");
            
            ArrayList<String> data = new ArrayList<>(
                    Arrays.asList(password, name, surname, role));

            // Svako jelo dodajemo u mapu:
            workers.put(username, data);
        }
    }
    
    DefaultTableModel modelRadnik;
    
    void showWorkersTable() {
        modelRadnik = (DefaultTableModel) tableRadnik.getModel();
        ArrayList<String> L;
        //dodajemo redke u tablicu hrane
        for(Map.Entry<String, ArrayList<String>> e : workers.entrySet()) {
            L = e.getValue();
            modelRadnik.addRow(new Object[]{
                e.getKey(),
                L.get(0),
                L.get(1),
                L.get(2),
                0 == L.get(3).compareTo("a")
            });
        }
    }
    
    void addRowRadnik(Object[] row) throws SQLException {
        String sql = "insert into Radnik(KORISNICKO_IME, LOZINKA, IME, PREZIME, ULOGA) "
                + "values(?, ?, ?, ?, ?)";
        PreparedStatement pstmt =  DatabaseConnection.conn.prepareStatement(sql);
        pstmt.setString(1, row[0].toString());
        pstmt.setString(2, row[2].toString());
        pstmt.setString(3, row[1].toString());
        pstmt.setString(4, row[3].toString());
        pstmt.setString(5, row[4].toString());
        AddWorker ss = new AddWorker(pstmt, this, row);
        ss.execute();
    }
    
    void addWorkerDialog() {
        String input = JOptionPane.showInputDialog(
                null, "username,lozinka,ime,prezime,admin=true/false");
        if(input == null) return;
        
        //if (!validateInput(input)) return;
        String[] inputs = input.split(",");
        
        try{
            Object[] row = new Object[]{
                inputs[0],
                inputs[1],
                inputs[2],
                inputs[3],
                Boolean.parseBoolean(inputs[4])
            };
            addRowRadnik(row);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this,
      "Pogrešno unešeni podaci. Pokušajte ponovo.");
        }

    }
    
    void removeWorkerDialog() {
        int selection = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da želite izbrisati označene račune?");
        //System.out.println(selection);
        if(selection == 0) {
            int [] rows = tableRadnik.getSelectedRows();
            if(rows.length > 1) {
                JOptionPane.showMessageDialog(this, "Molim odaberite samo jedan artikl.");
            }
            else {
                RemoveWorker task = new RemoveWorker(rows, this);
                task.execute();
            }
        }
        
        //model.getValueAt(1, 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMeal;
    private javax.swing.JButton addWorker;
    private javax.swing.JButton deleteMeal;
    private javax.swing.JLabel foodDataLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mealsPanel;
    private javax.swing.JLabel mealsPanelLabel;
    private javax.swing.JButton removeWorker;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tableHrana;
    private javax.swing.JTable tableRadnik;
    private javax.swing.JLabel workersDataLabel;
    // End of variables declaration//GEN-END:variables
}
