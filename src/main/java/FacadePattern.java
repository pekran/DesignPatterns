import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FacadePattern {
    public static void main(String[] args) {
        GeneralRdsFacade.printReports();
        GeneralRdsFacade.printReportByType("lte");
    }
}


class RbsNode {
    private final Integer id;
    private final String name;
    private final String type;

    RbsNode(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RbsNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class LteRbsNode extends RbsNode {
    LteRbsNode(Integer id, String name, String type) {
        super(id, name, type);
    }
}

class NrRbsNode extends RbsNode {
    NrRbsNode(Integer id, String name, String type) {
        super(id, name, type);
    }
}


// CtrLteHelper:
// 1. return list of LTE RBS-es
// 2. get LTE node by id
// 3. find LTE nodes by type

// CtrNrHelper
// 1. return list of NR RBS-es
// 2. get NR node by id
// 3. find NR nodes by type

class CtrLteHelper {
    public static List<LteRbsNode> getLteRbsNodes() {
        return Arrays.asList(
                new LteRbsNode(10, "RBS4g", "LTE 1 gen"),
                new LteRbsNode(11, "RBS4gUpgraded", "LTE 2 gen"),
                new LteRbsNode(12, "RBS4gUpgradedAgain", "LTE 2 gen")
        );
    }

    public static LteRbsNode getLteRbsNodeById(Integer id) {
        return getLteRbsNodes()
                .stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Error runtime"));
    }

    public static List<LteRbsNode> getLteRbsNodesByType(String nodeLteType) {
        List<LteRbsNode> lteRbsNodeList = new ArrayList<>();
        for (LteRbsNode lteRbsNode : getLteRbsNodes()) {
             if(lteRbsNode.getType().equalsIgnoreCase(nodeLteType)){
                 lteRbsNodeList.add(lteRbsNode);
            }
        }
        return lteRbsNodeList;
    }

    public static void printReport() {
        System.out.println("==========================================");
        System.out.println("All nodes: ");
        List<LteRbsNode> nodes = getLteRbsNodes();
        for (LteRbsNode node : nodes) {
            System.out.println(node);
        }
        System.out.println("Node by id 11 info:");
        System.out.println(getLteRbsNodeById(11));
        System.out.println("Nodes by type 'LTE 2 gen' info:");
        System.out.println(getLteRbsNodesByType("LTE 2 gen").stream().map(x -> x.getName()).collect(Collectors.joining(",")));
    }
}

class CtrNrHelper {
    public static List<NrRbsNode> getNrRbsNodes() {
        return Arrays.asList(
                new NrRbsNode(10, "RBS5g", "LTE 4 gen"),
                new NrRbsNode(11, "RBS5gUpgraded", "LTE 4 gen"),
                new NrRbsNode(12, "RBS5gUpgradedAgain", "LTE 5 gen")
        );
    }

    public static NrRbsNode getNrRbsNodeById(Integer id) {
        return getNrRbsNodes()
                .stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Error runtime"));
    }

    public static List<NrRbsNode> getNrRbsNodesByType(String nodeLteType) {
        List<NrRbsNode> nrRbsNodeList = new ArrayList<>();
        for (NrRbsNode lteRbsNode : getNrRbsNodes()) {
             if(lteRbsNode.getType().equalsIgnoreCase(nodeLteType)){
                 nrRbsNodeList.add(lteRbsNode);
            }
        }
        return nrRbsNodeList;
    }

    public static void printReport() {
        System.out.println("==========================================");
        System.out.println("All nodes: ");
        List<NrRbsNode> nodes = getNrRbsNodes();
        for (NrRbsNode node : nodes) {
            System.out.println(node);
        }
        System.out.println("Node by id 12 info:");
        System.out.println(getNrRbsNodeById(12));
        System.out.println("Nodes by type 'LTE 5 gen' info:");
        System.out.println(getNrRbsNodesByType("LTE 5 gen").stream().map(x -> x.getName()).collect(Collectors.joining(",")));
    }
}

// Facade to generate a full report consist of RBS[LTE, NR]
class GeneralRdsFacade {
    public static void printReports() {
        CtrLteHelper.printReport();
        CtrNrHelper.printReport();
    }

    public static void printReportByType(String type) {
        if(type.equalsIgnoreCase("Lte")){
            CtrLteHelper.printReport();
        }
        else if(type.equalsIgnoreCase("Nr")){
            CtrNrHelper.printReport();
        }
    }

    // ....
}