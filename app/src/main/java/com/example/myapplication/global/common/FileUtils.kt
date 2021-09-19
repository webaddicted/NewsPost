import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import java.io.File

/**
 * Author : Deepak sharma(webaddicted)
 * Email : deepaksharmatheboss@gmail.com
 * Profile : https://github.com/webaddicted
 */

class FileUtils {
    companion object {
        const val REQUEST_CAMERA_VIDEO: Int = 5000
        lateinit var captureVideoFile: File
        private const val APP_FOLDER = "kotlinProject"
        private const val SUB_PROFILE = "/profile"
        private const val VIDEO = "/Video"
        private const val MP4 = ".mp4"
        fun createApplicationFolder(activity: Activity) {
            var f = File(
                activity.dataDir,
                File.separator + APP_FOLDER
            )
            f.mkdirs()
            f = File(
                activity.dataDir,
                File.separator + APP_FOLDER + SUB_PROFILE
            )
            f.mkdirs()
            f = File(
                activity.dataDir,
                File.separator + APP_FOLDER + VIDEO
            )
            f.mkdirs()
        }

        fun getCaptureImageIntent(activity: Activity): Intent {
            captureVideoFile = createNewCaptureFile(activity)
            Log.d("TAG","File Path ${captureVideoFile.parent}")
            val intent: Intent?
            intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10)
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1)
            val photoURI = FileProvider.getUriForFile(
                activity,
                activity.packageName + ".provider",
                captureVideoFile
            )
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            activity.startActivityForResult(intent, REQUEST_CAMERA_VIDEO)
            return intent
        }

        private fun createNewCaptureFile(activity: Activity): File {
            val mFile = File(
                activity.dataDir,
                File.separator + APP_FOLDER + VIDEO + File.separator + "VIDEO_" + System.currentTimeMillis() + MP4
            )
            mFile.createNewFile()
            return mFile
        }
    }
}