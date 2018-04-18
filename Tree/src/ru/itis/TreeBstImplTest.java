package ru.itis;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class TreeBstImplTest {
    @Test
    public void contains(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        Assert.assertTrue(tree.contains(5));

    }
    @Test
    public void contains1(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        Assert.assertTrue(tree.contains(10));

    }@Test
    public void contains2(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        Assert.assertFalse(tree.contains(-1));

    }

    @Test
    public void equals(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        TreeBstImpl tree1 = new TreeBstImpl();
        for (int anArray : array) {
            tree1.insert(anArray);
        }

        Assert.assertEquals(tree, tree1);
//        Assert.assertEquals(true, tree.equals(tree1));
    }

    @Test
    public void isBst(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        Assert.assertTrue(tree.isBst());
    }

    @Test
    public void remove(){
        int[] array = {5, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};

        TreeBstImpl<Integer> actualTree = new TreeBstImpl();
        for (int anArray : array) {
            actualTree.insert(anArray);
        }
        actualTree.remove(4);
        Assert.assertFalse(actualTree.contains(4));
    }

    @Test
    public void remove1(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        tree.remove(2);
        Assert.assertTrue(tree.isBst());
        Assert.assertTrue(tree.contains(2));
    }

    @Test
    public void removeRoot(){
        int array[] = {5, 4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int anArray : array) {
            tree.insert(anArray);
        }
        tree.remove(5);
        Assert.assertTrue(tree.contains(5));
        Assert.assertTrue(tree.isBst());
    }
}