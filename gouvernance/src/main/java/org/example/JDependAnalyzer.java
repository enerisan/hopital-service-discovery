package org.example;

import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collection;


public class JDependAnalyzer {
    public static void main(String[] args) throws IOException {
        JDepend jdepend = new JDepend();

        // Analyser les classes compilées
        String baseDir = System.getProperty("user.dir");
        jdepend.addDirectory(baseDir + "/gouvernance/target/classes");

        StringUtils.isEmpty("");

        Collection<JavaPackage> packages = jdepend.analyze();

        for (JavaPackage pkg : packages) {
            System.out.println("\n=== Package: " + pkg.getName() + " ===");
            System.out.println("Classes concrètes: " + pkg.getConcreteClassCount());
            System.out.println("Classes abstraites: " + pkg.getAbstractClassCount());
            System.out.println("Afferent Coupling (Ca): " + pkg.afferentCoupling());
            System.out.println("Efferent Coupling (Ce): " + pkg.efferentCoupling());
            System.out.println("Instabilité (I): " + pkg.instability());
            System.out.println("Abstraction (A): " + pkg.abstractness());
            System.out.println("Distance (D): " + pkg.distance());
        }

        // Afficher les cycles si présents
        if (jdepend.containsCycles()) {
            Collection cycles = jdepend.getPackages();
            for (Object pkg : cycles) {
                JavaPackage javaPkg = (JavaPackage) pkg;
                if (javaPkg.containsCycle()) {
                    System.err.println("Cycle détecté dans: " + javaPkg.getName());
                }
            }
        }
    }
}