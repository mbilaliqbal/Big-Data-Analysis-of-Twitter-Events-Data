// ORM class for table 'game_goals'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu May 17 22:16:42 PDT 2018
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

public class game_goals extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer game_id;
  public Integer get_game_id() {
    return game_id;
  }
  public void set_game_id(Integer game_id) {
    this.game_id = game_id;
  }
  public game_goals with_game_id(Integer game_id) {
    this.game_id = game_id;
    return this;
  }
  private java.sql.Timestamp time;
  public java.sql.Timestamp get_time() {
    return time;
  }
  public void set_time(java.sql.Timestamp time) {
    this.time = time;
  }
  public game_goals with_time(java.sql.Timestamp time) {
    this.time = time;
    return this;
  }
  private Integer fc;
  public Integer get_fc() {
    return fc;
  }
  public void set_fc(Integer fc) {
    this.fc = fc;
  }
  public game_goals with_fc(Integer fc) {
    this.fc = fc;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof game_goals)) {
      return false;
    }
    game_goals that = (game_goals) o;
    boolean equal = true;
    equal = equal && (this.game_id == null ? that.game_id == null : this.game_id.equals(that.game_id));
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.fc == null ? that.fc == null : this.fc.equals(that.fc));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof game_goals)) {
      return false;
    }
    game_goals that = (game_goals) o;
    boolean equal = true;
    equal = equal && (this.game_id == null ? that.game_id == null : this.game_id.equals(that.game_id));
    equal = equal && (this.time == null ? that.time == null : this.time.equals(that.time));
    equal = equal && (this.fc == null ? that.fc == null : this.fc.equals(that.fc));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.game_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.time = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.fc = JdbcWritableBridge.readInteger(3, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.game_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.time = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.fc = JdbcWritableBridge.readInteger(3, __dbResults);
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
    JdbcWritableBridge.writeInteger(game_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(fc, 3 + __off, 4, __dbStmt);
    return 3;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(game_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(time, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeInteger(fc, 3 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.game_id = null;
    } else {
    this.game_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.time = null;
    } else {
    this.time = new Timestamp(__dataIn.readLong());
    this.time.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.fc = null;
    } else {
    this.fc = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.game_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.game_id);
    }
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.fc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.game_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.game_id);
    }
    if (null == this.time) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.time.getTime());
    __dataOut.writeInt(this.time.getNanos());
    }
    if (null == this.fc) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.fc);
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
    __sb.append(FieldFormatter.escapeAndEnclose(game_id==null?"null":"" + game_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc==null?"null":"" + fc, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(game_id==null?"null":"" + game_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(time==null?"null":"" + time, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(fc==null?"null":"" + fc, delimiters));
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.game_id = null; } else {
      this.game_id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc = null; } else {
      this.fc = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.game_id = null; } else {
      this.game_id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.time = null; } else {
      this.time = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.fc = null; } else {
      this.fc = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    game_goals o = (game_goals) super.clone();
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
    return o;
  }

  public void clone0(game_goals o) throws CloneNotSupportedException {
    o.time = (o.time != null) ? (java.sql.Timestamp) o.time.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("game_id", this.game_id);
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("fc", this.fc);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("game_id", this.game_id);
    __sqoop$field_map.put("time", this.time);
    __sqoop$field_map.put("fc", this.fc);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("game_id".equals(__fieldName)) {
      this.game_id = (Integer) __fieldVal;
    }
    else    if ("time".equals(__fieldName)) {
      this.time = (java.sql.Timestamp) __fieldVal;
    }
    else    if ("fc".equals(__fieldName)) {
      this.fc = (Integer) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("game_id".equals(__fieldName)) {
      this.game_id = (Integer) __fieldVal;
      return true;
    }
    else    if ("time".equals(__fieldName)) {
      this.time = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else    if ("fc".equals(__fieldName)) {
      this.fc = (Integer) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
