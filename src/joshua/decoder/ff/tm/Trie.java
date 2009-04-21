/* This file is part of the Joshua Machine Translation System.
 * 
 * Joshua is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307 USA
 */
package joshua.decoder.ff.tm;

import java.util.Collection;

import joshua.decoder.ff.tm.RuleCollection;


/**
 * An interface for trie-like data structures. Remember that in the
 * mathematical definition of a trie, each node is isomorphic to an
 * entire trie (just like any subtree of a tree is itself also a
 * tree, and like any tail of a linked list is itself also a linked
 * list).
 *
 * @author wren ng thornton <wren@users.sourceforge.net>
 * @author Zhifei Li, <zhifei.work@gmail.com>
 * @version $LastChangedDate$
 */
public interface Trie {
	
	/**
	 * Traverse one ply further down the trie. If there is no
	 * match, the result is null
	 */
	Trie matchOne(int wordID);
	
	
	/**
	 * Returns whether matchOne(Symbol) could succeed for any
	 * symbol.
	 */
	boolean hasExtensions();
	
	
	/**
	 * If the trie node has extensions, then return a list of
	 * extended trie nodes, otherwise return null.
	 */
	Collection<? extends Trie> getExtensions();
	
	
	/**
	 * Returns whether the current node/state is a "final state"
	 * that has matching rules.
	 */
	boolean hasRules();
	
	
	/** 
	 * Retrieve the rules at the current node/state. The
	 * implementation of this method must adhere to the following
	 * laws:
	 *
	 * (1) The return value is always non-null. The collection
	 *     may be empty however.
	 * (2) The collection must be empty if hasRules() is
	 *     false, and must be non-empty if hasRules() is true.
	 * (3) The collection must be sorted (at least as used by
	 *     TMGrammar)
	 */
	RuleCollection getRules();
	
}