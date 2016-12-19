package prob0720;


import java.util.HashMap;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @Frank Garcia
 */
public class Maps {
    
    public static final Map<String, Mnemon> unaryMnemonTable;
    public static final Map<String, Mnemon> nonUnaryMnemonTable;
    public static final Map<String, Mnemon> dotCommandMnemonTable;
    public static final Map<String, Mnemon> addrMnemonTable;
    public static final Map<String, Mnemon> brHelperMnemonTable;
    public static final Map<Mnemon, String> mnemonStringTable; 
    
    static {
        unaryMnemonTable = new HashMap<>();
        unaryMnemonTable.put("stop", Mnemon.M_STOP);
        unaryMnemonTable.put("asla", Mnemon.M_ASLA);
        unaryMnemonTable.put("asra", Mnemon.M_ASRA);
        
        nonUnaryMnemonTable = new HashMap<>();
        nonUnaryMnemonTable.put("br", Mnemon.M_BR);
        nonUnaryMnemonTable.put("brlt", Mnemon.M_BRLT);
        nonUnaryMnemonTable.put("breq", Mnemon.M_BREQ);
        nonUnaryMnemonTable.put("brle", Mnemon.M_BRLE);
        nonUnaryMnemonTable.put("cpa", Mnemon.M_CPA);
        nonUnaryMnemonTable.put("deci", Mnemon.M_DECI);
        nonUnaryMnemonTable.put("deco", Mnemon.M_DECO);
        nonUnaryMnemonTable.put("adda", Mnemon.M_ADDA);
        nonUnaryMnemonTable.put("suba", Mnemon.M_SUBA);
        nonUnaryMnemonTable.put("sta", Mnemon.M_STA);
        nonUnaryMnemonTable.put("lda", Mnemon.M_LDA);
        
        dotCommandMnemonTable = new HashMap<>();
        dotCommandMnemonTable.put("block", Mnemon.M_BLOCK);
        dotCommandMnemonTable.put("end", Mnemon.M_END);

        addrMnemonTable = new HashMap<>();
        addrMnemonTable.put("i", Mnemon.M_IMMEDIATE);
        addrMnemonTable.put("d", Mnemon.M_DIRECT);
        addrMnemonTable.put("n", Mnemon.M_INDIRECT);
        addrMnemonTable.put("s", Mnemon.M_STACKRELATIVE);
        addrMnemonTable.put("sf",Mnemon.M_STACKRELATIVEDEFERRED);
        addrMnemonTable.put("x",Mnemon.M_INDEXED);
        addrMnemonTable.put("sx",Mnemon.M_STACKINDEXED);
        addrMnemonTable.put("sxf",Mnemon.M_STACKINDEXEDDEFERRED);
        
        brHelperMnemonTable = new HashMap<>();
        brHelperMnemonTable.put("empty", Mnemon.M_E);
           
        mnemonStringTable = new EnumMap<>(Mnemon.class);
        mnemonStringTable.put(Mnemon.M_STOP, "STOP");
        mnemonStringTable.put(Mnemon.M_ASLA, "ASLA");
        mnemonStringTable.put(Mnemon.M_ASRA, "ASRA");
        mnemonStringTable.put(Mnemon.M_BR, "BR");
        mnemonStringTable.put(Mnemon.M_BRLT, "BRLT");
        mnemonStringTable.put(Mnemon.M_BREQ, "BREQ");
        mnemonStringTable.put(Mnemon.M_BRLE, "BRLE");
        mnemonStringTable.put(Mnemon.M_CPA, "CPA");
        mnemonStringTable.put(Mnemon.M_DECI, "DECI");
        mnemonStringTable.put(Mnemon.M_DECO, "DECO");
        mnemonStringTable.put(Mnemon.M_ADDA, "ADDA");
        mnemonStringTable.put(Mnemon.M_SUBA, "SUBA");
        mnemonStringTable.put(Mnemon.M_STA, "STA");
        mnemonStringTable.put(Mnemon.M_LDA, "LDA");
        mnemonStringTable.put(Mnemon.M_BLOCK, ".BLOCK");
        mnemonStringTable.put(Mnemon.M_END, ".END"); 
        mnemonStringTable.put(Mnemon.M_IMMEDIATE, "i");
        mnemonStringTable.put(Mnemon.M_DIRECT, "d");
        mnemonStringTable.put(Mnemon.M_INDIRECT, "n");
        mnemonStringTable.put(Mnemon.M_STACKRELATIVE, "s");
        mnemonStringTable.put(Mnemon.M_STACKRELATIVEDEFERRED, "sf");
        mnemonStringTable.put(Mnemon.M_INDEXED, "x");
        mnemonStringTable.put(Mnemon.M_STACKINDEXED, "sx");
        mnemonStringTable.put(Mnemon.M_STACKINDEXEDDEFERRED, "sxf"); 
        mnemonStringTable.put(Mnemon.M_E, ", ");
    }
}
