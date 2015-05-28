1.	Scenariul Aplicaţiei
      Se doreşte implementarea unei funcţionalităţi care simulează activitatea de contractere a unui credit bancar. Pentru a putea obţine un credit, o persoană trebuie să efectueze o serie de proceduri ce au scopul de a verifica eligibilitatea persoanei. Ȋn cazul în care condiţiile impuse de asigurare a eligibilităţii financiare a contractantului sunt îndeplinite, cererea de acordare a creditului va fi aprobată, iar utilizatorul va intra în posesia creditului.


2.	Analiză şi Implementare
Modelul aplicaţiei este reprezentat de entităţile: Credit bancar, Creditor (cel care pune la dispoziţie creditul şi Debitor (cel care pretinde creditul). Pentru implementare s-au utilizat  3 design patternuri, convenabile scenariului ales, şi s-au efectuat o serie de teste unitare pentru a testa corectitudinea metodelor create.
       Un credit bancar defineşte un obiect complex, cu următoarele caracteristici: 
-	Valoare credit, câmp de tipul “double”
-	Data contractare credit, de tip “Date”
-	Durata contractare, de tip “ int”
-	Tip dobanda, de tip “String”
-	Rata dobanzii,  de tip “double”
-	Moneda credit, de tip “String” (ex: Ron, Euro, Dolar..etc)
-	Unitate perioada contractare, de tip “String”  (ex: ani, luni)
-	Creditor, obiect de tip “Creditor”
-	Debitor, obiect de tip “Debitor”
-	Special, de tip “boolean”

Observaţie!   
Aceasta caracteristică defineşte o condiţie specială, asigurând o rată a dobânzii mai mică, dacă respectivul client (debitor) încasează salariul sau orice altă formă de venit într-un cont pus la dispoziţie de Creditor. Valoarea acestui câmp este “true”, dacă este îndeplinită condiţia de mai sus şi “false” în rest.
Un debitor se caracterizează prin datele personale de identificare:
-	Nume şi prenume, de tip “String”
-	Adresa, de tip “String”
-	Numar de telefon, de tip “String”
-	Venit net, de tip “double”

Observaţie! 
Venitul net reprezintă criteriul pentru verificarea eligibilităţii financiare a clientului.

Un creditor este, de regulă, o instituţie bancară. Acesta se caracterizează în principal prin:
-	Denumire, de tip “String”
-	Adresa, de tip “String”


Patternuri folosite
Ȋn realizarea funcţionalităţilor s-au utilizat o serie de design patternuri, cu scopul de a conferi stabilitate codului, pentru a-l menţine curat, lizibil şi uşor de înţeles.
         S-au implementat Builder, Strategy şi Façade. 
1.	Builder s-a folosit pentru crearea unui obiect de tip Credit Bancar, fiind necesare o serie de operaţii de actualizare pentru atribuirea de valori câmpurilor obiectului.
2.	Strategy a fost utilizat în metoda de calcul a dobânzii. Modul de calcul al dobânzii diferă, în funcţie de tipul de dobândă acordată: simplă sau compusă.
Ȋn cazul unei dobânzi simple, formula de calcul pentru valoarea dobânzii este: D=Cxd, unde D = valoarea dobânzii;
                     C= valoarea creditului contractat
                      d= rata dobânzii;
Ȋn cazul în care creditul este contractat în regim de dobânda compusă, valoarea dobânzii se calculează după formula:
SF = Cx(1+d)n
D=SF-C, unde C= creditul contractat
                       d= rata dobânzii
n = numărul de ani pe care a fost contractat creditul
                              SF= suma finala
                               D= valoarea dobânzii
 	Aşadar, în funcţie de “strategia” aleasă (tip dobândă), valoarea dobânzii se va calcula diferit.

3.	Façade este un pattern folosit pentru a “ascunde” funcţionalităţi complexe. Spuneam mai sus ca pentru a obţine creditul clientul (debitorul) trebuie să parcurgă  o serie de paşi (proceduri) prin care este verificată eligibilitatea acestuia.
Etapele acordării creditului sunt:
-	Iniţiere cerere acordare credit (din partea debitorului);
-	Verificare eligibilitate client (din partea creditorului):
1.	Dacă sunt îndeplinite condiţiile de eligibiltate, atunci se aprobă cererea;
2.	Dacă nu sunt îndeplinite condiţiile, atunci se respinge cererea.
-	Dacă 1 =>
a)	Furnizare date personale (de către client);
b)	Semnare contract (de către client);
c)	Ȋncasare suma (de către debitor);
d)	Ȋnştiinţare finală client (de către creditor).
Toate aceste operaţii vor fi mascate de o singură procedură, care va fi recunoscută de către contractant drept “Contracteaza Credit”.


3.	Testarea Aplicaţiei
         Pentru testarea corectitudinii implementării s-a decis realizarea unor teste unitare. Metodele de test sunt caracterizate de adnotarea @Test. Există de asemenea şi alte tipuri de adnotări, precum @Before, @After, @BeforeClass, @AfterClass. Metodele adnotate cu @Before se apelează înainte de fiecare test. Acestea sunt folosite pentru iniţializarea variabilelor şi/sau instanţierea obiectelor folosite în metodele de test. Metodele adnotate cu @After sunt apelate după execuţia fiecărui test scris. Se folosesc pentru eliberarea de resurse, închiderea de fişiere..etc.
           Metodele adnotate cu @BeforeClass au specific faptul că se execută o singură dată, înaintea tuturor metodelor de test din cadrul unui caz de test şi nu înainte de fiecare test în parte. Pe acelaşi principiu, metodele adnotate cu @AfterClass se execută  tot o singură dată, după rularea tuturor testelor. Aceste metode sunt utile atunci când se lucrează cu o bază de date. Conexiunea cu baza de date se va stabili în metoda adnotata cu @BeforeClass şi se va închide în metoda adnotată cu @AfterClass.

Metodele testate implementeaza următoarele funcţionalităţi:

-	Calculul ratei dobânzii, atât pentru un tip de dobândă simplă, cât şi pentru dobânda compusă, în cazul în care condiţia specială (vezi detaliere entitate Credit Bancar pentru lămuriri) este îndeplinită.
-	Validarea inputului “durata contractare credit”. Acest atribut nu poate primi valori negative. Acest lucru a fost asigurat de realizarea, urmata de declanşarea unei excepţii (DurataContractareCreditNenegativaException), în cazul în care nu se respectă condiţia de nenegativitate.
-	Formatarea calendaristică, pentru afişarea într-un mod customizat, ales de utilizator
-	Calculul dobânzii, în funcţie de tipul de dobândă şi de rata aferentă;
-	Teste pentru validarea diferilor metode folosind date de test dintr-un fişier .csv.


Observaţie!
1.	Pentru rularea testelor s-a utilizat un Runner, dar şi un TestSuite. 
2.	Utilizarea de obiecte mock pentru  testare



