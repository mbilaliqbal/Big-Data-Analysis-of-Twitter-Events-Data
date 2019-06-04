// ORM class for table 'game'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu May 17 22:16:13 PDT 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class game extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public game with_id(Integer id) {
    this.id = id;
    return this;
  }
  private Integer fc1;
  public Integer get_fc1() {
    return fc1;
  }
  public void set_fc1(Integer fc1) {
    this.fc1 = fc1;
  }
  public game with_fc1(Integer fc1) {
    this.fc1 = fc1;
    return this;
  }
  private Integer fc2;
  public Integer get_fc2() {
    return fc2;
  }
  public void set_fc2(Integer fc2) {
    this.fc2 = fc2;
  }
  public game with_fc2(Integer fc2) {
    this.fc2 = fc2;
    return this;
  }
  private java.sql.Timestamp officialstart;
  public java.sql.Timestamp get_officialstart() {
    return officialstart;
  }
  public void set_officialstart(java.sql.Timestamp officialstart) {
    this.officialstart = officialstart;
  }
  public game with_officialstart(java.sql.Timestamp officialstart) {
    this.officialstart = officialstart;
    return this;
  }
  private java.sql.Timestamp officialend;
  public java.sql.Timestamp get_officialend() {
    return officialend;
  }
  public void set_officialend(java.sql.Timestamp officialend) {
    this.officialend = officialend;
  }
  public game with_officialend(java.sql.Timestamp officialend) {
    this.officialend = officialend;
    return this;
  }
  private java.sql.Timestamp halftimestart;
  public java.sql.Timestamp get_halftimestart() {
    return halftimestart;
  }
  public void set_halftimestart(java.sql.Timestamp halftimestart) {
    this.halftimestart = halftimestart;
  }
  public game with_halftimestart(java.sql.Timestamp halftimestart) {
    this.halftimestart = halftimestart;
    return this;
  }
  private java.sql.Timestamp halftimeend;
  public java.sql.Timestamp get_halftimeend() {
    return halftimeend;
  }
  public void set_halftimeend(java.sql.Timestamp halftimeend) {
    this.halftimeend = halftimeend;
  }
  public game with_halftimeend(java.sql.Timestamp halftimeend) {
    this.halftimeend = halftimeend;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof game)) {
      return false;
    }
    game that = (game) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.fc1 == null ? that.fc1 == null : this.fc1.equals(that.fc1));
    equal = equal && (this.fc2 == null ? that.fc2 == null : this.fc2.equals(that.fc2));
    equal = equal && (this.officialstart == null ? that.officialstart == null : this.officialstart.equals(that.officialstart));
    equal = equal && (this.officialend == null ? that.officialend == null : this.officialend.equals(that.officialend));
    equal = equal && (this.halftimestart == null ? that.halftimestart == null : this.halftimestart.equals(that.halftimestart));
    equal = equal && (this.halftimeend == null ? that.halftimeend == null : this.halftimeend.equals(that.halftimeend));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof game)) {
      return false;
    }
    game that = (game) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.fc1 == null ? that.fc1 == null : this.fc1.equals(that.fc1));
    equal = equal && (this.fc2 == null ? that.fc2 == null : this.fc2.equals(that.fc2));
    equal = equal && (this.officialstart == null ? that.officialstart == null : this.officialstart.equals(that.officialstart));
    equal = equal && (this.officialend == null ? that.officialend == null : this.officialend.equals(that.officialend));
    equal = equal && (this.halftimestart == null ? that.halftimestart == null : this.halftimestart.equals(that.halftimestart));
    equal = equal && (this.halftimeend == null ? that.halftimeend == null : this.halftimeend.equals(that.halftimeend));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.fc1 = JdbcWritableBridge.readInteger(2, __dbResults);
    this.fc2 = JdbcWritableBridge.readInteger(3, __dbResults);
    this.officialstart = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.officialend = JdbcWritableBridge.readTimestamp(5, __dbResults);
    this.halftimestart = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.halftimeend = JdbcWritableBridge.readTimestamp(7, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.fc1 = JdbcWritableBridge.readInteger(2, __dbResults);
    this.fc2 = JdbcWritableBridge.readInteger(3, __dbResults);
    this.officialstart = JdbcWritableBridge.readTimestamp(4, __dbResults);
    this.officialend = JdbcWritableBridge.readTimestamp(5, __dbResults);
    this.halftimestart = JdbcWritableBridge.readTimestamp(6, __dbResults);
    this.halftimeend = JdbcWritableBridge.readTimestamp(7, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(fc1, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(fc2, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(officialstart, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(officialend, 5 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(halftimestart, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(halftimeend, 7 + __off, 93, __dbStmt);
    return 7;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(fc1, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(fc2, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(officialstart, 4 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(officialend, 5 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(halftimestart, 6 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeTimestamp(halftimeend, 7 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.fc1 = null;
    } else {
    this.fc1 = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.fc2 = null;
    } else {
    this.fc2 = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.officialstart = null;
    } else {
    this.officialstart = new Timestamp(__dataIn.readLong());
    this.officialstart.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.officialend = null;
    } else {
    this.officialend = new Timestamp(__dataIn.readLong());
    this.officialend.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.halftimestart = null;
    } else {
    this.halftimestart = new Timestamp(__dataIn.readLong());
    this.halftimestart.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.halftimeend = null;
    } else {
    this.halftimeend = new Timestamp(__dataIn.readLong());
    this.halftimeend.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.fc1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc1);
    }
    if (null == this.fc2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc2);
    }
    if (null == this.officialstart) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.officialstart.getTime());
    __dataOut.writeInt(this.officialstart.getNanos());
    }
    if (null == this.officialend) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.officialend.getTime());
    __dataOut.writeInt(this.officialend.getNanos());
    }
    if (null == this.halftimestart) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.halftimestart.getTime());
    __dataOut.writeInt(this.halftimestart.getNanos());
    }
    if (null == this.halftimeend) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.halftimeend.getTime());
    __dataOut.writeInt(this.halftimeend.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.fc1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc1);
    }
    if (null == this.fc2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc2);
    }
    if (null == this.officialstart) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.officialstart.getTime());
    __dataOut.writeInt(this.officialstart.getNanos());
    }
    if (null == this.officialend) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.officialend.getTime());
    __dataOut.writeInt(this.officialend.getNanos());
    }
    if (null == this.halftimestart) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.halftimestart.getTime());
    __dataOut.writeInt(this.halftimestart.getNanos());
    }
    if (null == this.halftimeend) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.halftimeend.getTime());
    __dataOut.writeInt(this.halftimeend.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc1==null?"null":"" + fc1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc2==null?"null":"" + fc2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officialstart==null?"null":"" + officialstart, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officialend==null?"null":"" + officialend, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(halftimestart==null?"null":"" + halftimestart, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(halftimeend==null?"null":"" + halftimeend, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc1==null?"null":"" + fc1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc2==null?"null":"" + fc2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officialstart==null?"null":"" + officialstart, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(officialend==null?"null":"" + officialend, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(halftimestart==null?"null":"" + halftimestart, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(halftimeend==null?"null":"" + halftimeend, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 1, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc1 = null; } else {
      this.fc1 = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc2 = null; } else {
      this.fc2 = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.officialstart = null; } else {
      this.officialstart = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.officialend = null; } else {
      this.officialend = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.halftimestart = null; } else {
      this.halftimestart = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.halftimeend = null; } else {
      this.halftimeend = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc1 = null; } else {
      this.fc1 = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc2 = null; } else {
      this.fc2 = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.officialstart = null; } else {
      this.officialstart = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.officialend = null; } else {
      this.officialend = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.halftimestart = null; } else {
      this.halftimestart = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.halftimeend = null; } else {
      this.halftimeend = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    game o = (game) super.clone();
    o.officialstart = (o.officialstart != null) ? (java.sql.Timestamp) o.officialstart.clone() : null;
    o.officialend = (o.officialend != null) ? (java.sql.Timestamp) o.officialend.clone() : null;
    o.halftimestart = (o.halftimestart != null) ? (java.sql.Timestamp) o.halftimestart.clone() : null;
    o.halftimeend = (o.halftimeend != null) ? (java.sql.Timestamp) o.halftimeend.clone() : null;
    return o;
  }

  public void clone0(game o) throws CloneNotSupportedException {
    o.officialstart = (o.officialstart != null) ? (java.sql.Timestamp) o.officialstart.clone() : null;
    o.officialend = (o.officialend != null) ? (java.sql.Timestamp) o.officialend.clone() : null;
    o.halftimestart = (o.halftimestart != null) ? (java.sql.Timestamp) o.halftimestart.clone() : null;
    o.halftimeend = (o.halftimeend != null) ? (java.sql.Timestamp) o.halftimeend.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("fc1", this.fc1);
    __sqoop$field_map.put("fc2", this.fc2);
    __sqoop$field_map.put("officialstart", this.officialstart);
    __sqoop$field_map.put("officialend", this.officialend);
    __sqoop$field_map.put("halftimestart", this.halftimestart);
    __sqoop$field_map.put("halftimeend", this.halftimeend);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("fc1", this.fc1);
    __sqoop$field_map.put("fc2", this.fc2);
    __sqoop$field_map.put("officialstart", this.officialstart);
    __sqoop$field_map.put("officialend", this.officialend);
    __sqoop$field_map.put("halftimestart", this.halftimestart);
    __sqoop$field_map.put("halftimeend", this.halftimeend);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
    }
    else    if ("fc1".equals(__fieldName)) {
      this.fc1 = (Integer) __fieldVal;
    }
    else    if ("fc2".equals(__fieldName)) {
      this.fc2 = (Integer) __fieldVal;
    }
    else    if ("officialstart".equals(__fieldName)) {
      this.officialstart = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("officialend".equals(__fieldName)) {
      this.officialend = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("halftimestart".equals(__fieldName)) {
      this.halftimestart = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("halftimeend".equals(__fieldName)) {
      this.halftimeend = (java.sql.Timestamp) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
      return true;
    }
    else    if ("fc1".equals(__fieldName)) {
      this.fc1 = (Integer) __fieldVal;
      return true;
    }
    else    if ("fc2".equals(__fieldName)) {
      this.fc2 = (Integer) __fieldVal;
      return true;
    }
    else    if ("officialstart".equals(__fieldName)) {
      this.officialstart = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("officialend".equals(__fieldName)) {
      this.officialend = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("halftimestart".equals(__fieldName)) {
      this.halftimestart = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("halftimeend".equals(__fieldName)) {
      this.halftimeend = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
