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
package net.rptools.mtscript.script;

import java.util.HashMap;
import java.util.Map;
import net.rptools.mtscript.language.I18N;

/** Class for holding the symbol table for a script. */
public class ScriptSymbolTable {

  // private final Map<String, FunctionNode> functionsMap = new HashMap<>();
  private final Map<String, Object> variableMap = new HashMap<>();
  private final Map<String, Object> globalVariableMap = new HashMap<>();
  private final Map<String, Object> constantMap = new HashMap<>();
  private final Map<String, Object> propertyMap = new HashMap<>();


  private final ScriptSymbolTable parentSymbolTable;

  /**
   * Creates a new {@code ScriptSymbolTable} with a parent scope.
   * @param parent the parent scope for the symbol table.
   */
  public ScriptSymbolTable(ScriptSymbolTable parent) {
    parentSymbolTable = parent;
  }

  /**
   * Creates a new {@code ScriptSymbolTable} with no parent scope.
   */
  public ScriptSymbolTable() {
    parentSymbolTable = null;
  }


  /**
   * Adds a new constant to the symbol table. If the constant has been defined either in this symbol
   * table or any of its ancestors then {@link IllegalStateException} will be thrown.
   *
   * @param name The name of the constant to add.
   * @param integer the integer value to set the constant to.
   *
   * @throws IllegalStateException if the constant has already been defined.
   */
  public void addConstant(String name, Object integer) {
    if (hasConstant(name)) {
      throw new IllegalStateException(I18N.getText("symbolTable.constant.exists", name));
    }

    constantMap.put(name, integer);
  }

  /**
   * Checks to see if this constant. has been defined either in this symbol table or any of its ancestors.
   * @param name the name of the constant.
   * @return {@code true} if the constant has already been defined otherwise {@code false}.
   */
  public boolean hasConstant(String name) {
    if (constantMap.containsKey(name)) {
      return true;
    }

    if (parentSymbolTable != null) {
      return parentSymbolTable.hasConstant(name);
    }

    return false;
  }
}
