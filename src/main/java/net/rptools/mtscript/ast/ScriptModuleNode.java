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
package net.rptools.mtscript.ast;

import static java.util.Objects.requireNonNull;

import java.util.List;
import net.rptools.mtscript.script.ScriptExport;
import net.rptools.mtscript.script.ScriptImport;

/**
 * {@code ASTNode} used to hold the details of a MTS2 Script Module.
 */
public class ScriptModuleNode implements ASTNode {
  /** The name of the script module. */
  private final String name;
  /** The version of the script module. */
  private final String version;
  /** The description of the script module. */
  private final String description;
  /** The imports for the script module. */
  private final List<ScriptImport> imports;
  /**a */
  private final List<DeclarationNode> declarations;
  private final List<ScriptExport> exports;

  /**
   *
   * @param name
   * @param version
   * @param description
   * @param imports
   * @param declarations
   * @param exports
   */
  public ScriptModuleNode(
      String name,
      String version,
      String description,
      List<ScriptImport> imports,
      List<DeclarationNode> declarations,
      List<ScriptExport> exports) {
    this.name = requireNonNull(name, "name");
    this.version = requireNonNull(version, "version");
    this.description = requireNonNull(description, "description");
    this.imports = List.copyOf(requireNonNull(imports, "imports"));
    this.declarations = requireNonNull(declarations, "declarations");
    this.exports = List.copyOf(requireNonNull(exports, "exports"));
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  public String getDescription() {
    return description;
  }

  public List<ScriptImport> getImports() {
    return imports;
  }

  public List<DeclarationNode> getDeclarations() {
    return declarations;
  }

  public List<ScriptExport> getExports() {
    return exports;
  }
}
