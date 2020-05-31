/*
 * This software Copyright by the RPTools.net development team, and
 * licensed under the Affero GPL Version 3 or, at your option, any later
 * version.
 *
 * RPTools Source Code is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public
 * License * along with this source Code.  If not, please visit
 * <http://www.gnu.org/licenses/> and specifically the Affero license
 * text at <http://www.gnu.org/licenses/agpl.html>.
 */
package net.rptools.mtscript.symboltable;

import java.util.Optional;

/** Implementation of the {@link SymbolTable} interface for symbol tables for the script. */
class StandardSymbolTable implements SymbolTable {

  /** The scope level of the symbol table. */
  private final int level;

  /** The factory class used to crate {@link SymbolTableEntry}. */
  private SymbolTableEntryFactory symbolTableEntryFactory;

  /**
   * Creates a new {@code StandardSymbolTable} with the specified scope level.
   *
   * @param scopeLevel the scope level of the symbol table.
   */
  public StandardSymbolTable(SymbolTableEntryFactory factory, int scopeLevel) {
    level = scopeLevel;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public SymbolTableEntry create(String name) {
    return null;
  }

  @Override
  public Optional<SymbolTableEntry> lookup(String name) {
    return Optional.empty();
  }
}
