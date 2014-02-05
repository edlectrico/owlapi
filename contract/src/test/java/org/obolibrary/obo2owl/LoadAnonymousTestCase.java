/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2014, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2014, The University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.obolibrary.obo2owl;

import static org.junit.Assert.assertEquals;
import static org.semanticweb.owlapi.apibinding.OWLFunctionalSyntaxFactory.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

@SuppressWarnings("javadoc")
public class LoadAnonymousTestCase {
    @Test
    public void shouldLoad() throws OWLOntologyCreationException {
        OWLOntologyManager rootOntologyManager = OWLManager
                .createOWLOntologyManager();
        String input = "format-version: 1.2\n"
                + "date: 27:06:2013 17:08\n"
                + "saved-by: gkoutos\n"
                + "auto-generated-by: OBO-Edit 2.3\n"
                + "subsetdef: abnormal_slim \"Abnormal/normal slim\"\n"
                + "subsetdef: absent_slim \"Absent/present slim\"\n"
                + "subsetdef: attribute_slim \"Attribute slim\"\n"
                + "subsetdef: cell_quality \"cell_quality\"\n"
                + "subsetdef: disposition_slim \"Disposition slim\"\n"
                + "subsetdef: mpath_slim \"Pathology slim\"\n"
                + "subsetdef: prefix_slim \"prefix slim\"\n"
                + "subsetdef: relational_slim \"Relational slim: types of quality that require an additional entity in order to exist\"\n"
                + "subsetdef: scalar_slim \"Scalar slim\"\n"
                + "subsetdef: unit_group_slim \"unit group slim\"\n"
                + "subsetdef: unit_slim \"unit slim\"\n"
                + "subsetdef: value_slim \"Value slim\"\n"
                + "default-namespace: quality\n"
                + "namespace-id-rule: * UO:$sequence(7,0,9999999)$\n"
                + "remark: Filtered by Ancestor ID equals \"UO:0000000\"\n"
                + "ontology: uo\n"
                + "ontology: pato\n"
                + "ontology: pato\n"
                + "ontology: pato\n"
                + "\n"
                + "[Term]\n"
                + "id: UO:0000000\n"
                + "name: unit\n"
                + "namespace: unit.ontology\n"
                + "def: \"A unit of measurement is a standardized quantity of a physical quality.\" [Wikipedia:Wikipedia]\n"
                + "created_by: george gkoutos\n"
                + "\n"
                + "[Term]\n"
                + "id: UO:0000001\n"
                + "name: length unit\n"
                + "namespace: unit.ontology\n"
                + "def: \"A unit which is a standard measure of the distance between two points.\" [Wikipedia:Wikipedia]\n"
                + "subset: unit_group_slim\n" + "is_a: UO:0000000 ! unit\n"
                + "relationship: is_unit_of PATO:0001708 ! 1-D extent\n"
                + "created_by: george gkoutos";
        StringDocumentSource streamDocumentSource = new StringDocumentSource(
                input);
        OWLOntologyLoaderConfiguration loaderConfig = new OWLOntologyLoaderConfiguration()
                .setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT);
        OWLOntology ontology = rootOntologyManager
                .loadOntologyFromOntologyDocument(streamDocumentSource,
                        loaderConfig);
        OWLAnnotationProperty date = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#date"));
        OWLAnnotationProperty mpath_slim = AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#mpath_slim"));
        OWLAnnotationProperty SubsetProperty = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#SubsetProperty"));
        OWLAnnotationProperty attribute_slim = AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#attribute_slim"));
        OWLAnnotationProperty hasOBONamespace = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#hasOBONamespace"));
        OWLAnnotationProperty autogeneratedby = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#auto-generated-by"));
        OWLAnnotationProperty hasDbXref = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#hasDbXref"));
        OWLAnnotationProperty defaultnamespace = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#default-namespace"));
        OWLAnnotationProperty hasOBOFormatVersion = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#hasOBOFormatVersion"));
        OWLAnnotationProperty IAO_0000115 = AnnotationProperty(IRI("http://purl.obolibrary.org/obo/IAO_0000115"));
        OWLAnnotationProperty NamespaceIdRule = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#NamespaceIdRule"));
        OWLAnnotationProperty created_by = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#created_by"));
        OWLAnnotationProperty inSubset = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#inSubset"));
        OWLAnnotationProperty savedby = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#saved-by"));
        OWLClass PATO_0001708 = Class(IRI("http://purl.obolibrary.org/obo/PATO_0001708"));
        OWLClass UO_0 = Class(IRI("http://purl.obolibrary.org/obo/UO_0000000"));
        OWLClass UO_1 = Class(IRI("http://purl.obolibrary.org/obo/UO_0000001"));
        OWLAnnotationProperty id = AnnotationProperty(IRI("http://www.geneontology.org/formats/oboInOwl#id"));
        OWLAnnotationProperty abnormal_slim = AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#abnormal_slim"));
        OWLAnnotationProperty scalar_slim = AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#scalar_slim"));
        Set<OWLAxiom> expected = new HashSet<OWLAxiom>(
                Arrays.asList(
                        Declaration(date),
                        Declaration(autogeneratedby),
                        Declaration(hasDbXref),
                        Declaration(defaultnamespace),
                        Declaration(SubsetProperty),
                        Declaration(hasOBOFormatVersion),
                        Declaration(IAO_0000115),
                        Declaration(NamespaceIdRule),
                        Declaration(created_by),
                        Declaration(inSubset),
                        Declaration(savedby),
                        Declaration(PATO_0001708),
                        Declaration(UO_0),
                        Declaration(RDFSComment()),
                        Declaration(RDFSLabel()),
                        Declaration(hasOBONamespace),
                        Declaration(UO_1),
                        Declaration(id),
                        SubAnnotationPropertyOf(mpath_slim, SubsetProperty),
                        AnnotationAssertion(
                                hasOBONamespace,
                                IRI("http://purl.obolibrary.org/obo/UO_0000001"),
                                Literal("unit.ontology",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                attribute_slim.getIRI(),
                                Literal("Attribute slim",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(RDFSLabel(), IAO_0000115.getIRI(),
                                Literal("definition", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                hasOBONamespace,
                                UO_0.getIRI(),
                                Literal("unit.ontology",
                                        OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#unit_slim")),
                                SubsetProperty),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#value_slim"),
                                Literal("Value slim", OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#absent_slim")),
                                SubsetProperty),
                        SubAnnotationPropertyOf(abnormal_slim, SubsetProperty),
                        AnnotationAssertion(RDFSLabel(), UO_1.getIRI(),
                                Literal("length unit", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSLabel(),
                                hasOBOFormatVersion.getIRI(),
                                Literal("has_obo_format_version",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSLabel(),
                                NamespaceIdRule.getIRI(),
                                Literal("namespace-id-rule",
                                        OWL2Datatype.XSD_STRING)),
                        SubClassOf(
                                UO_1,
                                ObjectSomeValuesFrom(
                                        ObjectProperty(IRI("http://purl.obolibrary.org/obo/uo#is_unit_of")),
                                        PATO_0001708)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#cell_quality")),
                                SubsetProperty),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#relational_slim"),
                                Literal("Relational slim: types of quality that require an additional entity in order to exist",
                                        OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#prefix_slim")),
                                SubsetProperty),
                        SubAnnotationPropertyOf(scalar_slim, SubsetProperty),
                        AnnotationAssertion(RDFSComment(),
                                scalar_slim.getIRI(),
                                Literal("Scalar slim", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                abnormal_slim.getIRI(),
                                Literal("Abnormal/normal slim",
                                        OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(attribute_slim, SubsetProperty),
                        AnnotationAssertion(RDFSLabel(), UO_0.getIRI(),
                                Literal("unit", OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#disposition_slim")),
                                SubsetProperty),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#unit_slim"),
                                Literal("unit slim", OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#relational_slim")),
                                SubsetProperty),
                        AnnotationAssertion(id, UO_1.getIRI(),
                                Literal("UO:0000001", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                mpath_slim.getIRI(),
                                Literal("Pathology slim",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                created_by,
                                UO_1.getIRI(),
                                Literal("george gkoutos",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSLabel(),
                                hasDbXref.getIRI(),
                                Literal("database_cross_reference",
                                        OWL2Datatype.XSD_STRING)),
                        SubClassOf(UO_1, UO_0),
                        AnnotationAssertion(
                                RDFSLabel(),
                                hasOBONamespace.getIRI(),
                                Literal("has_obo_namespace",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(id, UO_0.getIRI(),
                                Literal("UO:0000000", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                created_by,
                                UO_0.getIRI(),
                                Literal("george gkoutos",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#prefix_slim"),
                                Literal("prefix slim", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#cell_quality"),
                                Literal("cell_quality", OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#absent_slim"),
                                Literal("Absent/present slim",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSLabel(),
                                SubsetProperty.getIRI(),
                                Literal("subset_property",
                                        OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#unit_group_slim")),
                                SubsetProperty),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#unit_group_slim"),
                                Literal("unit group slim",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(
                                RDFSComment(),
                                IRI("http://purl.obolibrary.org/obo/uo#disposition_slim"),
                                Literal("Disposition slim",
                                        OWL2Datatype.XSD_STRING)),
                        AnnotationAssertion(RDFSLabel(), inSubset.getIRI(),
                                Literal("in_subset", OWL2Datatype.XSD_STRING)),
                        SubAnnotationPropertyOf(
                                AnnotationProperty(IRI("http://purl.obolibrary.org/obo/uo#value_slim")),
                                SubsetProperty),
                        AnnotationAssertion(
                                inSubset,
                                UO_1.getIRI(),
                                IRI("http://purl.obolibrary.org/obo/uo#unit_group_slim")),
                        OWLManager
                                .getOWLDataFactory()
                                .getOWLAnnotationAssertionAxiom(
                                        IAO_0000115,
                                        UO_0.getIRI(),
                                        Literal("A unit of measurement is a standardized quantity of a physical quality.",
                                                OWL2Datatype.XSD_STRING),
                                        Collections
                                                .singleton(Annotation(
                                                        hasDbXref,
                                                        Literal("Wikipedia:Wikipedia",
                                                                OWL2Datatype.XSD_STRING)))),
                        OWLManager
                                .getOWLDataFactory()
                                .getOWLAnnotationAssertionAxiom(
                                        IAO_0000115,
                                        UO_1.getIRI(),
                                        Literal("A unit which is a standard measure of the distance between two points.",
                                                OWL2Datatype.XSD_STRING),
                                        Collections
                                                .singleton(Annotation(
                                                        hasDbXref,
                                                        Literal("Wikipedia:Wikipedia",
                                                                OWL2Datatype.XSD_STRING))))));
        assertEquals(expected, ontology.getAxioms());
    }
}