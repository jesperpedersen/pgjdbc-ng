package com.impossibl.postgres.system.procs;

import java.io.IOException;

import com.impossibl.postgres.Context;
import com.impossibl.postgres.types.Type;
import com.impossibl.postgres.utils.DataInputStream;
import com.impossibl.postgres.utils.DataOutputStream;


public class Int4s extends SimpleProcProvider {

	public Int4s() {
		super(null, null, new Encoder(), new Decoder(), "int4", "oid", "tid", "xid", "cid", "regproc");
	}
	
	static class Decoder implements Type.BinaryIO.Decoder {

		public Integer decode(Type type, DataInputStream stream, Context context) throws IOException {			
			return stream.readInt();
		}

	}

	static class Encoder implements Type.BinaryIO.Encoder {

		public void encode(Type type, DataOutputStream stream, Object val, Context context) throws IOException {
			stream.writeInt((Integer)val);
		}

	}

}
